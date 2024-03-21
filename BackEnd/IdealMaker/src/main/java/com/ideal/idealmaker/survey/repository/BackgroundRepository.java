package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.Background;

public interface BackgroundRepository extends JpaRepository<Background, Integer> {
	Background getById(Integer id);
}
