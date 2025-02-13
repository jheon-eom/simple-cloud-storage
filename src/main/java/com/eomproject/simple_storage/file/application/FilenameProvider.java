package com.eomproject.simple_storage.file.application;

import org.springframework.stereotype.Service;

@Service
public class FilenameProvider {

    private static final String PATH_SEPARATOR = "/";
    private static final String ROOT_DIRECTORY = "/app/storage";

    public String createDirectoryNameWith(Long userId) {
        return ROOT_DIRECTORY + PATH_SEPARATOR + userId;
    }
}
