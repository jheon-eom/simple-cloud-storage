package com.eomproject.simple_storage.directory.adapter.out.persistance;

import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryRepository;
import com.eomproject.simple_storage.directory.application.port.in.GetDirectoryQuery;
import com.eomproject.simple_storage.directory.domain.Directory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetDirectoryJpaAdapter implements GetDirectoryQuery {

    private final DirectoryRepository directoryRepository;

    @Override
    public Directory getDirectory(Long directoryId) {
        return null;
    }
}
