package com.eomproject.simple_storage.file.mock;

import com.eomproject.simple_storage.file.application.FilenameProvider;

public class TestFilenameProvider extends FilenameProvider {

    private static final String PATH_SEPARATOR = "/";
    private static final String ROOT_DIRECTORY = "/apptest/storage";

    public String createDirectoryNameWith(Long userId) {
        return ROOT_DIRECTORY + PATH_SEPARATOR + userId;
    }
}
