package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.directory.application.port.in.GetDirectoryQuery;
import com.eomproject.simple_storage.directory.domain.Directory;
import com.eomproject.simple_storage.file.application.port.in.UploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RequiredArgsConstructor
@Service
public class UploadFileService implements UploadFileUseCase {

    private final GetDirectoryQuery getDirectoryQuery;

    @Override
    public void uploadFile(Long directoryId, MultipartFile uploadFile, Long loginUserId) {
        Directory directory = getDirectoryQuery.getDirectory(directoryId);
        verifyDirectoryOwnership(directory, loginUserId);
        try {
            if (uploadFile.getSize() > 1_073_741_824) { // 1GB in bytes
                splitAndSaveFile(uploadFile, directory.getPath());
            } else {
                uploadFile.transferTo(Path.of(directory.getPath()));
            }
        } catch (Exception e) {
            throw new IllegalStateException("Failed to upload file");
        }
    }

    private void verifyDirectoryOwnership(Directory directory, Long loginUserId) {
        if (!directory.getOwner().getId().equals(loginUserId)) {
            throw new IllegalStateException("Directory does not belong to the user");
        }
    }

    private void splitAndSaveFile(MultipartFile uploadFile, String directoryPath) throws IOException {
        int partCounter = 1;
        byte[] buffer = new byte[256 * 1024 * 1024]; // 256MB buffer
        ExecutorService executorService = Executors.newFixedThreadPool(4); // 4 threads
        List<Future<Void>> futures = new ArrayList<>();

        try (InputStream inputStream = uploadFile.getInputStream()) {
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) > 0) {
                final int partNumber = partCounter++;
                final byte[] partData = Arrays.copyOf(buffer, bytesRead);
                int finalBytesRead = bytesRead;
                futures.add(executorService.submit(() -> {
                    Path partPath = Path.of(directoryPath, uploadFile.getOriginalFilename() + ".part" + partNumber);
                    try (OutputStream outputStream = Files.newOutputStream(partPath, StandardOpenOption.CREATE)) {
                        outputStream.write(partData, 0, finalBytesRead);
                    }
                    return null;
                }));
            }
        }

        for (Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IOException("Failed to save file part", e);
            }
        }

        executorService.shutdown();
    }
}
