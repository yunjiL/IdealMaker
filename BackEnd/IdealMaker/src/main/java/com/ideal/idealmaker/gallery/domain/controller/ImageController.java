package com.ideal.idealmaker.gallery.domain.controller;


import com.ideal.idealmaker.gallery.domain.model.Image;
import com.ideal.idealmaker.gallery.domain.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }


    //이미지 전체 조회
    @GetMapping
    public ResponseEntity<Page<Image>> getAllImages(Pageable pageable) {
        Page<Image> images = imageService.findAllImages(pageable);
        return ResponseEntity.ok(images);
    }

    //이미지 상세 조회
    @GetMapping("/{idealId}")
    public ResponseEntity<Image> getImageById(@PathVariable Long idealId) {
       Image image = imageService.findImageById(idealId);
        if (image != null) {
            return ResponseEntity.ok(image);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //동물상 필터링 검색
    @GetMapping("/serch")
    public ResponseEntity<Page<Image>> findByAnimalType(
            @RequestParam String animalType,
            Pageable pageable) {
        Page<Image> images = imageService.findByAnimalType(animalType, pageable);
        return ResponseEntity.ok(images);
    }

    //페이지네이션
}