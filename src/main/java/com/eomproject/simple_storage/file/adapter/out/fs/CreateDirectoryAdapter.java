package com.eomproject.simple_storage.file.adapter.out.fs;

import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreateDirectoryAdapter implements CreateDirectoryPort {

    @Override
    public void createDirectory(String directoryPath) {
        try {
            Files.createDirectory(Path.of(directoryPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
