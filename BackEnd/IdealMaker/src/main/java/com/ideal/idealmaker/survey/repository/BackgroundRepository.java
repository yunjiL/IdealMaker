package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.Background;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface BackgroundRepository extends JpaRepository<Background, Integer> {
	Background getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(b.id, b.background) FROM Background b")
	List<SelectDto> findIdAndBackground();
}
