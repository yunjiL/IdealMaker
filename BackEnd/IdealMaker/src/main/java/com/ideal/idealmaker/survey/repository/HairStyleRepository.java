package com.ideal.idealmaker.survey.repository;

import com.ideal.idealmaker.component.domain.HairStyle;
import com.ideal.idealmaker.survey.dto.SelectDto;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface HairStyleRepository extends JpaRepository<HairStyle, Integer> {
	HairStyle getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(h.id, h.hairStyle) "
		   + "FROM HairStyle h WHERE h.gender.id = :genderId")
	List<SelectDto> findIdAndHairStyle(@Param("genderId") int genderId);
}
