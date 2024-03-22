package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.Concept;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(c.id, c.concept) FROM Concept c")
	List<SelectDto> findIdAndConcept();
}
