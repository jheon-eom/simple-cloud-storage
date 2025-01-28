package com.eomproject.simple_storage.user.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {
}
