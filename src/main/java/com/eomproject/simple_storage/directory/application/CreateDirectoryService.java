package com.eomproject.simple_storage.directory.application;

import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryJpaEntity;
import com.eomproject.simple_storage.directory.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.directory.application.port.out.CreateDirectoryPort;
import com.eomproject.simple_storage.directory.application.port.out.SaveDirectoryPort;
import com.eomproject.simple_storage.directory.domain.Directory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    // domain service
    private final DirectoryNameProvider directoryNameProvider;

    // out port
    private final CreateDirectoryPort createDirectoryPort;
    private final SaveDirectoryPort saveDirectoryPort;

    @Override
    public void createRootDirectory(Long userId) {
        String createDirectoryPath = directoryNameProvider.extractDirectoryNameWith(userId);
        String createdPath = createDirectoryPort.createDirectory(createDirectoryPath);
        saveDirectoryPort.saveDirectoryMetadata(userId, createdPath);
    }
}
