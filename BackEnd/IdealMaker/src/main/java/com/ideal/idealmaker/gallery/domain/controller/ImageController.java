package com.ideal.idealmaker.gallery.domain.controller;


import com.ideal.idealmaker.gallery.domain.model.Image;
import com.ideal.idealmaker.gallery.domain.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }


    //이미지 전체 조회
    public ResponseEntity<Page<Image>> getImages(

    )

    //이미지 상세 조회

    //동물상 필터링 검색

    //페이지네이션
}