package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.component.domain.HairLength;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface HairLengthRepository extends JpaRepository<HairLength, Integer> {
	HairLength getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(h.id, h.hairLength) FROM HairLength h")
	List<SelectDto> findIdAndHairLength();
}
