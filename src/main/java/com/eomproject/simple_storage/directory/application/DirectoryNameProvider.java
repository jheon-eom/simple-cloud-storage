package com.eomproject.simple_storage.directory.application;

import org.springframework.stereotype.Service;

@Service
public class DirectoryNameProvider {

    private static final String PATH_SEPARATOR = "/";
    private static final String ROOT_PATH = "/Users/eomjongheon";
    private static final String APP_PATH = "/app/storage";

    public String extractDirectoryNameWith(Long userId) {
        return ROOT_PATH + APP_PATH + PATH_SEPARATOR + userId;
    }
}
