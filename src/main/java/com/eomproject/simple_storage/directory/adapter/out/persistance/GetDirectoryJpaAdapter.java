package com.eomproject.simple_storage.directory.adapter.out.persistance;

import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryJpaEntity;
import com.eomproject.simple_storage.directory.adapter.out.persistance.jpa.DirectoryRepository;
import com.eomproject.simple_storage.directory.application.port.in.GetDirectoryQuery;
import com.eomproject.simple_storage.directory.domain.Directory;
import com.eomproject.simple_storage.directory.domain.Owner;
import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;
import com.eomproject.simple_storage.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetDirectoryJpaAdapter implements GetDirectoryQuery {

    private final DirectoryRepository directoryRepository;

    @Override
    public Directory getDirectory(Long directoryId) {
        DirectoryJpaEntity directoryJpaEntity = directoryRepository.getDirectoryById(directoryId);
        return toModel(directoryJpaEntity);
    }

    private Directory toModel(DirectoryJpaEntity directoryJpaEntity) {
        UserJpaEntity userJpaEntity = directoryJpaEntity.getUser();

        if (userJpaEntity == null) {
            throw new IllegalStateException("Directory owner not found");
        }

        return Directory.builder()
                .owner(Owner.builder()
                        .id(userJpaEntity.getId())
                        .account(userJpaEntity.getAccount())
                        .build())
                .path(directoryJpaEntity.getPath())
                .createdAt(directoryJpaEntity.getCreatedAt())
                .modifiedAt(directoryJpaEntity.getModifiedAt())
                .build();
    }
}
