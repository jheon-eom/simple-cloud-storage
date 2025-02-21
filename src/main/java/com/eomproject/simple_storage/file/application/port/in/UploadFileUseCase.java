package com.eomproject.simple_storage.file.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

    void uploadFile(Long directoryId, MultipartFile file, Long loginUserId);
}
