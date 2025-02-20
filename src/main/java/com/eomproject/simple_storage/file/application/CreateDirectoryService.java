package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.adapter.out.persistance.jpa.DirectoryJpaEntity;
import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;
import com.eomproject.simple_storage.file.application.port.out.SaveDirectoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    // domain service
    private final FilenameProvider filenameProvider;

    // out port
    private final CreateDirectoryPort createDirectoryPort;
    private final SaveDirectoryPort saveDirectoryPort;

    @Override
    public void createRootDirectory(Long userId) {
        String createDirectoryPath = filenameProvider.extractDirectoryNameWith(userId);
        String createdPath = createDirectoryPort.createDirectory(createDirectoryPath);

        DirectoryJpaEntity directoryJpaEntity = toEntity(userId, createdPath);
        saveDirectoryPort.saveDirectoryMetadata(directoryJpaEntity);
    }

    private DirectoryJpaEntity toEntity(Long userId, String createdPath) {
        DirectoryJpaEntity directoryJpaEntity = DirectoryJpaEntity.builder()
                .path(createdPath)
                .userId(userId)
                .build();
        return directoryJpaEntity;
    }
}
