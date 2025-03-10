package com.eomproject.simple_storage.common.auth.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.common.entity.AuditingEntity;
import com.eomproject.simple_storage.user.domain.User;
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

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
