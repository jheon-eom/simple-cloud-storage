package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    private static final String ROOT_DIRECTORY = "/storage";

    private final CreateDirectoryPort createDirectoryPort;

    @Override
    public void createRootDirectory(Long userId) {
        String rootDirectory = ROOT_DIRECTORY + "/" + userId;
        createDirectoryPort.createDirectory(rootDirectory);
    }
}
