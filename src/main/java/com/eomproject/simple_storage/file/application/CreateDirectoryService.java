package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    private static final String ROOT_DIRECTORY = "/storage";

    @Transactional
    @Override
    public void createRootDirectory(Long userId) {
        String rootDirectory = ROOT_DIRECTORY + "/" + userId;

    }
}
