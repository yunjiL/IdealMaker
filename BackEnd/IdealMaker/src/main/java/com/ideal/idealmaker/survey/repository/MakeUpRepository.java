package com.ideal.idealmaker.survey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ideal.idealmaker.component.domain.MakeUp;
import com.ideal.idealmaker.survey.dto.SelectDto;

public interface MakeUpRepository extends JpaRepository<MakeUp, Integer> {
	MakeUp getById(Integer id);

	@Query("SELECT new com.ideal.idealmaker.survey.dto.SelectDto(m.id, m.makeUp) FROM MakeUp m")
	List<SelectDto> findIdAndMakeUp();
}
