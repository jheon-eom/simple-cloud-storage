package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.adapter.out.persistance.jpa.DirectoryJpaEntity;
import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;
import com.eomproject.simple_storage.file.application.port.out.SaveDirectoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    // constants
    private static final String PATH_SEPARATOR = "/";
    private static final String ROOT_DIRECTORY = "/storage";

    // out port
    private final CreateDirectoryPort createDirectoryPort;
    private final SaveDirectoryPort saveDirectoryPort;

    @Transactional(propagation = Propagation.REQUIRED) // 부모 트랜잭션이 존재하면 참여
    @Override
    public void createRootDirectory(Long userId) {
        String path = createPath(userId);
        String createdPath = createDirectoryPort.createDirectory(path);

        DirectoryJpaEntity directoryJpaEntity = toEntity(userId, createdPath);
        saveDirectoryPort.saveDirectoryMetadata(directoryJpaEntity);
    }

    private String createPath(Long userId) {
        return ROOT_DIRECTORY + PATH_SEPARATOR + userId;
    }

    private DirectoryJpaEntity toEntity(Long userId, String createdPath) {
        DirectoryJpaEntity directoryJpaEntity = DirectoryJpaEntity.builder()
                .path(createdPath)
                .userId(userId)
                .build();
        return directoryJpaEntity;
    }
}
