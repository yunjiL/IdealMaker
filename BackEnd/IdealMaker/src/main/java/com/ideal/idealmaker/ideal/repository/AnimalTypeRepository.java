package com.ideal.idealmaker.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideal.idealmaker.ideal.domain.AnimalType;

@Repository
public interface AnimalTypeRepository extends JpaRepository<AnimalType,Long> {
	AnimalType getById(Long id);
}
