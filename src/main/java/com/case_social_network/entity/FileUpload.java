package com.case_social_network.entity;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
