package com.eomproject.simple_storage.common.auth.adapter.out.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSessionRepository extends JpaRepository<UserSessionJpaEntity, Long> {

}
