package com.eomproject.simple_storage.directory.adapter.out.persistance.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DirectoryRepository extends JpaRepository<DirectoryJpaEntity, Long> {

    @Query("""
                SELECT d
                FROM DirectoryJpaEntity d
                JOIN FETCH d.user
                WHERE d.id = :id
            """)
    DirectoryJpaEntity getDirectoryById(@Param("id") Long directoryId);
}
