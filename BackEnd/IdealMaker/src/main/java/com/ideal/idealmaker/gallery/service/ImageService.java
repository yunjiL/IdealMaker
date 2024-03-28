package com.ideal.idealmaker.gallery.service;

import com.ideal.idealmaker.gallery.data.ImageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ImageService {
    Page<ImageDTO> findAllImages(Pageable pageable);
    ImageDTO findImageById(Long idealId);
    Page<ImageDTO> findByAnimalType(String animalType, Pageable pageable);
    Page<ImageDTO> findByGenderId(int genderId, Pageable pageable);
}
