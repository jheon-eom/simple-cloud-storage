package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.application.port.in.CreateDirectoryUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateDirectoryService implements CreateDirectoryUseCase {

    private static final String ROOT_DIRECTORY = "/storage";

    @Override
    public void createDirectory(Long loginUserId) {
        // 사용자의 root 디렉토리가 존재하는지 검사
        String path = ROOT_DIRECTORY + "/" + loginUserId;
        findDirectoryPort.findDirectoryByPath(path);
    }
}
