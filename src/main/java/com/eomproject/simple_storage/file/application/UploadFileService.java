package com.eomproject.simple_storage.file.application;

import com.eomproject.simple_storage.file.application.port.in.UploadFileUseCase;
import com.eomproject.simple_storage.file.domain.FileNameValidator;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService implements UploadFileUseCase {

//    private final FileNameValidator fileNameValidator;
    private static final long MAX_FILE_SIZE = 1024 * 1024 * 1000; // 1GB
    private static final long DIVIDE_FILE_SIZE = 1024 * 1024 * 100; // 100MB

    @Override
    public void uploadFile(String directory, MultipartFile file, Long loginUserId) {
        /**
         * 1. 파일을 저장할 path의 이름을 검사한다. (중복되면 안 됨)
         *
         * 1. 파일을 최대 사이즈를 검사한다.
         * 2. 파일을 분할한다.
         * 3. 분할한 파일을 파일과 파일의 블록 리스트로 저장한다.
         */

//        String file
//        fileNameValidator.validate(file.getName());
//
//        fileSizeValidate(file.getSize());

    }

    private void fileSizeValidate(long size) {
        if (size > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size is too large");
        }
    }
}
