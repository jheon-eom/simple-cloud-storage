package com.eomproject.simple_storage.user.adapter.out.persistance.jpa;

import com.eomproject.simple_storage.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<UserJpaEntity, Long> {

    boolean existsByAccount(@Param("account") String account);

    User findByAccount(String account);
}
