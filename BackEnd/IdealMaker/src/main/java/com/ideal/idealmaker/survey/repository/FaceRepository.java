package com.ideal.idealmaker.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.component.domain.Face;

public interface FaceRepository extends JpaRepository<Face, Integer> {
	Face getById(Integer id);
}
