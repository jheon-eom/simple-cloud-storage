package com.eomproject.simple_storage.file.adapter.out.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectoryRepository extends JpaRepository<DirectoryJpaEntity, Long> {

}
