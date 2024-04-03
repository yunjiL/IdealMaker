package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.Face;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface FaceRepository extends JpaRepository<Face, Integer> {

	Face getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(f.id, f.face) FROM Face f")
	List<SelectDto> findIdAndFace();
}
