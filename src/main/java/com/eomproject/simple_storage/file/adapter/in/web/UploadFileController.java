package com.eomproject.simple_storage.file.adapter.in.web;

import com.eomproject.simple_storage.common.auth.domain.UserSessionContext;
import com.eomproject.simple_storage.file.application.port.in.UploadFileUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
@RestController
public class UploadFileController {

    private final UploadFileUseCase uploadFileUseCase;

    @PostMapping("/{directoryId}")
    public ResponseEntity<Void> uploadFile(@PathVariable Long directoryId, MultipartFile file) {
        uploadFileUseCase.uploadFile(directoryId, file, UserSessionContext.getUserId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
