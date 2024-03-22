package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ideal.idealmaker.component.domain.Concept;
import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {
	Concept getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(c.id, c.concept) "
		   + "FROM Concept c WHERE c.gender.id = :genderId")
	List<SelectDto> findIdAndConcept(@Param("genderId") int genderId);
}
