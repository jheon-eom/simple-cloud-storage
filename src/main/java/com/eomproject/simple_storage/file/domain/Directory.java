package com.eomproject.simple_storage.file.domain;

import java.time.LocalDateTime;

public class Directory {

    // root/{userId}/{directoryName}

    private Uploader uploader;

    private String name;

    private LocalDateTime createdAt;
}
