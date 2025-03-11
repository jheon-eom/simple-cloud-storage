package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.directory.application.port.in.GetDirectoryQuery;
import com.eomproject.simple_storage.directory.domain.Directory;
import com.eomproject.simple_storage.file.application.port.in.UploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@RequiredArgsConstructor
@Service
public class UploadFileService implements UploadFileUseCase {

    private final GetDirectoryQuery getDirectoryQuery;

    @Transactional
    @Override
    public void uploadFile(Long directoryId, MultipartFile uploadFile, Long loginUserId) {
        Directory directory = getDirectoryQuery.getDirectory(directoryId);

        verifyDirectoryOwnership(directory, loginUserId);

        try {
            uploadFile.transferTo(Path.of(directory.getPath()));
        } catch (Exception e) {
            throw new IllegalStateException("Failed to upload file");
        }
    }

    private void verifyDirectoryOwnership(Directory directory, Long loginUserId) {
        if (!directory.getOwner().getId().equals(loginUserId)) {
            throw new IllegalStateException("Directory does not belong to the user");
        }
    }
}
