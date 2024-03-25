package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.ClothStyle;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface ClothStyleRepository extends JpaRepository<ClothStyle, Integer> {
	ClothStyle getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(c.id, c.clothStyle) FROM ClothStyle c")
	List<SelectDto> findIdAndClothStyle();
}
