package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.MakeUp;

import jakarta.persistence.criteria.CriteriaBuilder;

public interface MakeUpRepository extends JpaRepository<MakeUp, Integer> {
	MakeUp getById(Integer id);
}
