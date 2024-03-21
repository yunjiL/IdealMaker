package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.ClothStyle;

public interface ClothStyleRepository extends JpaRepository<ClothStyle, Integer> {
	ClothStyle getById(Integer id);
}
