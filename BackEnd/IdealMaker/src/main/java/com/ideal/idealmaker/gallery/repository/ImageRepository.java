package com.ideal.idealmaker.gallery.repository;

import com.ideal.idealmaker.gallery.domain.model.Image;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    //동물상 필터링 검색
    Page<Image> findByAnimalType(String animalType, Pageable pageable);
}
