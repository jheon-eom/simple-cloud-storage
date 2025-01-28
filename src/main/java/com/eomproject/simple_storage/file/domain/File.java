package com.eomproject.simple_storage.file.domain;

import java.time.LocalDateTime;
import java.util.Set;

public class File {

    private String filename;

    private Directory directory;

    private Uploader uploader;

    private Set<FileBlock> fileBlocks;

    private LocalDateTime uploadAt;

    private int size;

    public void modifyFilename(final String modifyFilename) {
        this.filename = modifyFilename;
    }
}
