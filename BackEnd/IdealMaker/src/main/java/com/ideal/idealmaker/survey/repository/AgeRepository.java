package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.Age;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface AgeRepository extends JpaRepository<Age, Integer> {
	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(a.id, a.age) FROM Age a")
	List<SelectDto> findIdAndAge();
	Age getById(Integer id);
}
