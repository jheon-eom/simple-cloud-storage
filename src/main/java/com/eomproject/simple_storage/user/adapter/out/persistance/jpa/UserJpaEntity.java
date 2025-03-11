package com.eomproject.simple_storage.user.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.common.entity.AuditingEntity;
import com.eomproject.simple_storage.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class UserJpaEntity extends AuditingEntity {

    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true)
    private String account;

    private String password;
}
