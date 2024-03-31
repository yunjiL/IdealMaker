package com.ideal.idealmaker.gallery.repository;

import com.ideal.idealmaker.ideal.domain.Ideal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Ideal, Long> {

    // 특정 동물상에 해당하는 이상형 조회
    @Query("SELECT i FROM Ideal i WHERE i.animalType.type = :animalType")
    Page<Ideal> findByAnimalType(String animalType, Pageable pageable);

    // 특정 성별에 해당하는 이상형 조회
    @Query("SELECT i FROM Ideal i WHERE i.idealCharacter.gender.id = :genderId")
    Page<Ideal> findByGenderId(Integer genderId, Pageable pageable);

}
