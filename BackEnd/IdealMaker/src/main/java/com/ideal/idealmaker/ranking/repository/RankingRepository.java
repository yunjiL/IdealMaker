package com.ideal.idealmaker.ranking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ideal.idealmaker.ideal.domain.AnimalType;


/*
 * 	작성자 : 정여민
 * 	작성 일시 : 2024.03.21
 * 	업데이트 : 2024.03.21
 *	네용 : 동물상 랭킹순으로 반환처리 위한 JPA
 * */

@Repository
public interface RankingRepository extends JpaRepository<AnimalType, Integer> {




}
