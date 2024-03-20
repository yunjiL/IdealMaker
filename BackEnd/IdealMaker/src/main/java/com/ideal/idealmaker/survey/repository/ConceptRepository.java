package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.Concept;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {
}
