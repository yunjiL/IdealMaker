package com.ideal.idealmaker.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideal.idealmaker.ideal.domain.Ideal;

@Repository
public interface IdealRepository extends JpaRepository<Ideal,Long> {
	Ideal getById(Long id);
}