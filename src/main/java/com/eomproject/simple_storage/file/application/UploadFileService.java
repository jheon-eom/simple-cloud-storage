package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.directory.application.port.in.GetDirectoryQuery;
import com.eomproject.simple_storage.directory.domain.Directory;
import com.eomproject.simple_storage.file.application.port.in.UploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class UploadFileService implements UploadFileUseCase {

    private final GetDirectoryQuery getDirectoryQuery;

    @Transactional
    @Override
    public void uploadFile(Long directoryId, MultipartFile file, Long loginUserId) {
        Directory directory = getDirectoryQuery.getDirectory(directoryId);

        verifyDirectoryOwnership(directory, loginUserId);
    }

    private void verifyDirectoryOwnership(Directory directory, Long loginUserId) {

    }
}
