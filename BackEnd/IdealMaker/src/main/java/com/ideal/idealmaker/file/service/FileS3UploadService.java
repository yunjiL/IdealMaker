package com.ideal.idealmaker.file.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ideal.idealmaker.file.dto.FileInfoDto;

public interface FileS3UploadService {

    // 파일 하나만 저장할 때 사용
    FileInfoDto uploadFile(String uploadPath, MultipartFile multipartFile);

    // 파일 여러개를 저장할 때 사용
    List<FileInfoDto> uploadFlieList(String uploadPath, List<MultipartFile> multipartFiles);

    void removeFile(String fileName);

    public void removeFolderFiles(String uploadPath);
}
