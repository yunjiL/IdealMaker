package com.ideal.idealmaker.ideal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideal.idealmaker.ideal.domain.IdealCharacter;

@Repository
public interface IdealCharacterRepository extends JpaRepository<IdealCharacter,Integer> {
	IdealCharacter getById(Integer id);
}
