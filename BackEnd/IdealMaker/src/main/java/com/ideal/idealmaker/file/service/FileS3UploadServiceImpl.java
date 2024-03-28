package com.ideal.idealmaker.file.service;


import static com.ideal.idealmaker.exception.ExceptionMessage.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ideal.idealmaker.exception.IllegalExtensionException;
import com.ideal.idealmaker.file.dto.FileInfoDto;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Object;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;


@Service
@RequiredArgsConstructor
public class FileS3UploadServiceImpl implements FileS3UploadService {
    private final S3Client s3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    /**
     * 파일이름 랜덤생성 메소드
     *
     * @param
     * @return
     */
    private String generateRandomName() {
        String random = UUID.randomUUID().toString();
        return random;
    }

    /**
     * 이미지 url을 s3 버킷에 업로드
     * 
     * @param idealId
     * @param imageUrl
     * @return
     */
    @Override
    public FileInfoDto uploadImageURL(String idealId, String imageUrl) {

        String generatedName = idealId + "/" + generateRandomName(); //새로 생성된 이미지 이름


        try {
            // 외부 이미지 URL에서 InputStream 생성
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream inputStream = connection.getInputStream();

            // S3에 이미지 업로드
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(generatedName)
                .contentType("image/png")
                .build();

            s3Client.putObject(putObjectRequest,
                RequestBody.fromInputStream(inputStream, connection.getContentLengthLong()));

            // 리소스 해제
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileURL = s3Client.utilities().getUrl(GetUrlRequest.builder().bucket(bucketName).key(generatedName).build()).toExternalForm();
        return FileInfoDto.builder()
            .fileName(generatedName)
            .fileURL(fileURL)
            .build();
    }
}
