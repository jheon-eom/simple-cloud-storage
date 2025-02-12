package com.eomproject.simple_storage.file.adapter.out.filesystem;

import com.eomproject.simple_storage.file.application.port.out.CreateDirectoryPort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class CreateDirectoryFileSystemAdapter implements CreateDirectoryPort {

    @Override
    public String createDirectory(String path) {
        try {
            Path createdPath = Files.createDirectory(Path.of(path));
            return createdPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("Failed to create directory : " + path);
        }
    }
}
