package com.ideal.idealmaker.gallery.domain.service;
import com.ideal.idealmaker.gallery.domain.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ImageService {
    Page<Image> findAllImages(Pageable pageable);
    Image findImageById(Long id);
    Page<Image> findByAnimalType(String animalType, Pageable pageable);
}