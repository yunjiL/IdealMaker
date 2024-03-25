package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.SkinColor;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface SkinColorRepository extends JpaRepository<SkinColor, Integer> {
	SkinColor getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(s.id, s.skinColor) FROM SkinColor s")
	List<SelectDto> findIdAndSkinColor();
}
