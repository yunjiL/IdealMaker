package com.ideal.idealmaker.gallery.domain.service;

import com.ideal.idealmaker.gallery.domain.model.Image;
import com.ideal.idealmaker.gallery.domain.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


public interface ImageService {
    Page<Image> findAllImages(Pageable pageable);
    Image findImageById(Long id);
    Page<Image> findByAnimalType(String animalType, Pageable pageable);
}