package com.ideal.idealmaker.gallery.service;
import com.ideal.idealmaker.gallery.domain.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ImageService {
    Page<Image> findAllImages(Pageable pageable);
    Image findImageById(Long idealId);
    Page<Image> findByAnimalType(String animalType, Pageable pageable);
}