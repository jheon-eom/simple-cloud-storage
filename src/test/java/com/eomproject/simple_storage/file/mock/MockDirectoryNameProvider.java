package com.eomproject.simple_storage.file.mock;

import com.eomproject.simple_storage.directory.application.DirectoryNameProvider;

public class MockDirectoryNameProvider extends DirectoryNameProvider {

    private static final String PATH_SEPARATOR = "/";
    private static final String ROOT_PATH = "/Users/eomjongheon";
    private static final String TEST_APP_PATH = "/apptest/storage";

    public String extractDirectoryNameWith(Long userId) {
        return ROOT_PATH + TEST_APP_PATH + PATH_SEPARATOR + userId;
    }
}
