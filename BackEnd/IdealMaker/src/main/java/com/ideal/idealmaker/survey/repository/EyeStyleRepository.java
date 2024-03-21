package com.ideal.idealmaker.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.EyeStyle;

public interface EyeStyleRepository extends JpaRepository<EyeStyle, Integer> {
	EyeStyle getById(Integer id);
}
