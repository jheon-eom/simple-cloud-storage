package com.eomproject.simple_storage.file.application.port.in;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFileUseCase {

    void uploadFile(String directory, MultipartFile file, Long loginUserId);
}
