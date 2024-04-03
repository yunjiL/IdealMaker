package com.ideal.idealmaker.gallery.service;

import com.ideal.idealmaker.gallery.dto.ImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {

    Page<ImageDto> findAllImages(Pageable pageable);
    ImageDto findImageById(Long idealId);
    Page<ImageDto> findByAnimalType(String animalType, Pageable pageable);
    Page<ImageDto> findByGenderId(Integer genderId, Pageable pageable);

}
