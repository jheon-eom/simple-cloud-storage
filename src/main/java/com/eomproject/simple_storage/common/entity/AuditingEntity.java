package com.eomproject.simple_storage.common.entity;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public class AuditingEntity {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
