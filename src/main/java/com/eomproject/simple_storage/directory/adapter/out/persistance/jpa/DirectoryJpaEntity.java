package com.eomproject.simple_storage.directory.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.common.entity.AuditingEntity;
import com.eomproject.simple_storage.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

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
    private User user;

    private String path;

    private boolean isDeleted;
}
