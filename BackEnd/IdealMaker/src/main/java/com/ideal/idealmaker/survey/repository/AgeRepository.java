package com.ideal.idealmaker.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.Age;

public interface AgeRepository extends JpaRepository<Age, Integer> {
	Age getById(Integer id);
}
