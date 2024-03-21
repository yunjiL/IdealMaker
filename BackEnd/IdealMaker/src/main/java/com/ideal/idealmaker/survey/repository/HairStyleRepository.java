package com.ideal.idealmaker.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.HairStyle;


public interface HairStyleRepository extends JpaRepository<HairStyle,Integer> {
	HairStyle getById(Integer id);
}
