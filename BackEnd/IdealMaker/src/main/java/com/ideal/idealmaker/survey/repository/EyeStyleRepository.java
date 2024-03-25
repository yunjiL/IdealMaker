package com.ideal.idealmaker.survey.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.EyeStyle;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface EyeStyleRepository extends JpaRepository<EyeStyle, Integer> {
	EyeStyle getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(e.id, e.eyeStyle) FROM EyeStyle e")
	List<SelectDto> findIdAndEyeStyle();

}
