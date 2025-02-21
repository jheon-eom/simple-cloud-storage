package com.eomproject.simple_storage.directory.adapter.out.filesystem;

import com.eomproject.simple_storage.directory.application.port.out.CreateDirectoryPort;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class CreateDirectoryFileSystemAdapter implements CreateDirectoryPort {

    @Override
    public String createDirectory(String directoryPath) {
        try {
            Path createdPath = Files.createDirectories(Path.of(directoryPath));
            return createdPath.toString();
        } catch (IOException e) {
            throw new RuntimeException("File system occur error");
        }
    }
}
