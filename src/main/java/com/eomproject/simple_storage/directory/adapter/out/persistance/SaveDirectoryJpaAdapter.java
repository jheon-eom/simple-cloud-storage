package com.eomproject.simple_storage.directory.adapter.out.persistance;

import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryJpaEntity;
import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryRepository;
import com.eomproject.simple_storage.directory.application.port.out.SaveDirectoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SaveDirectoryJpaAdapter implements SaveDirectoryPort {

    private final DirectoryRepository directoryRepository;

    @Override
    public void saveDirectoryMetadata(DirectoryJpaEntity directoryJpaEntity) {
        directoryRepository.save(directoryJpaEntity);
    }
}
