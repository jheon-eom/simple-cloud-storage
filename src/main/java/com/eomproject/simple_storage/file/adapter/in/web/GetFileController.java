package com.eomproject.simple_storage.file.adapter.in.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/files")
@RestController
public class GetFileController {

    @GetMapping("/{directoryId}")
    public void getFiles(@PathVariable Long directoryId) {
        // TODO: Implement
    }
}
