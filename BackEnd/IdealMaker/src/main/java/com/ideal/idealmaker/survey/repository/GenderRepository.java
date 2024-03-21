package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.Gender;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
