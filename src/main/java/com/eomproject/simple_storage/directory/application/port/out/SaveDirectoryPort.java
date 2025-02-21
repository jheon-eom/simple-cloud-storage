package com.eomproject.simple_storage.directory.application.port.out;

import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryJpaEntity;

public interface SaveDirectoryPort {

    void saveDirectoryMetadata(DirectoryJpaEntity directoryJpaEntity);
}
