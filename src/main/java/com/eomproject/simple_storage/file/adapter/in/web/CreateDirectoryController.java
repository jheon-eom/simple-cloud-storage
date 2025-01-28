package com.eomproject.simple_storage.file.adapter.in.web;

import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/directories")
@RestController
public class CreateDirectoryController {

    private final CreateDirectoryUseCase createDirectoryUseCase;

    @PostMapping
    public ResponseEntity<Void> createDirectory(Long loginUserId, String directory) {
        createDirectoryUseCase.createDirectory(loginUserId, directory);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
