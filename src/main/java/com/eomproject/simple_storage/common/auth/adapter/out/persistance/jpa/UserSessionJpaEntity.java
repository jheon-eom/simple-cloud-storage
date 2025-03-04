package com.eomproject.simple_storage.common.auth.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.common.entity.AuditingEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "user_session")
@Entity
public class UserSessionJpaEntity extends AuditingEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String key;

    private String account;
}
