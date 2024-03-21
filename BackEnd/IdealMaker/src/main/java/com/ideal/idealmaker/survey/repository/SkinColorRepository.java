package com.ideal.idealmaker.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.SkinColor;

public interface SkinColorRepository extends JpaRepository<SkinColor, Integer> {
	SkinColor getById(Integer id);
}
