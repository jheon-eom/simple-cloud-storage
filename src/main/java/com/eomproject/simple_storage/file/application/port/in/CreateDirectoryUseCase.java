package com.eomproject.simple_storage.file.application.port.in;

public interface CreateDirectoryUseCase {

    void createDirectory(Long loginUserId, String directory);
}
