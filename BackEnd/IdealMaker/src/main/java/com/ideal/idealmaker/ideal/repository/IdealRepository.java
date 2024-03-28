package com.ideal.idealmaker.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideal.idealmaker.ideal.domain.Ideal;

public interface IdealRepository extends JpaRepository<Ideal,Long> {
	Ideal getById(Long id);
}
