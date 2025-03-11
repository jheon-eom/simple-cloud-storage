package com.eomproject.simple_storage.directory.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Directory {

    private String path;

    private Owner owner;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}