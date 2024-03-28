package com.ideal.idealmaker.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ideal.idealmaker.file.dto.FileInfoDto;

public interface FileS3UploadService {

    FileInfoDto uploadImageURL(String keyName, String imageUrl);
}
