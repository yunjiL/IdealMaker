package com.ideal.idealmaker.gallery.domain.service;

import com.ideal.idealmaker.gallery.domain.model.Image;
import com.ideal.idealmaker.gallery.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageService (ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    //이미지 전체 조회 (페이지네이션)
    public Page<Image> findAllImage(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    //이미지 상세 조회 (idealId)
    public Image findImageById(Long idealId) {
        return imageRepository.findById(idealId).orElse(null);
    }

    //동물상 필터링 검색 (선택하면 그 페이지에 해당 동물상만 나오게)
    public Page<Image> findByAnimalType(String animalType, Pageable pageable) {
        return imageRepository.findByAnimalType(animalType, pageable);
    }
}