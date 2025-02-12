package com.eomproject.simple_storage.file.application.port.out;

import com.eomproject.simple_storage.file.adapter.out.persistance.jpa.DirectoryJpaEntity;

public interface SaveDirectoryPort {

    void saveDirectoryMetadata(DirectoryJpaEntity directoryJpaEntity);
}
