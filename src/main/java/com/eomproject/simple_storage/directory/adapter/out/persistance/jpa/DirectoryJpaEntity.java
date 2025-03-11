package com.eomproject.simple_storage.directory.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.common.entity.AuditingEntity;
import com.eomproject.simple_storage.user.adapter.out.persistance.jpa.UserJpaEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "directories")
@Entity
public class DirectoryJpaEntity extends AuditingEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity user;

    private String path;

    private boolean isDeleted;
}
