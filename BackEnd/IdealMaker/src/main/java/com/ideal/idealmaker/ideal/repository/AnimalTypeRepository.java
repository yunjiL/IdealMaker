package com.ideal.idealmaker.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.ideal.domain.AnimalType;

public interface AnimalTypeRepository extends JpaRepository<AnimalType,Long> {
	AnimalType getById(Long id);
}
