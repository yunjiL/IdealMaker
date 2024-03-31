package com.ideal.idealmaker.gallery.repository;

import com.ideal.idealmaker.gallery.dto.ImageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<ImageDTO, Long>{

    //동물상 필터링 검색
    Page<ImageDTO> findByAnimalType(String animalType, Pageable pageable);
    Page<ImageDTO> findByGenderId(int genderId, Pageable pageable);

}
