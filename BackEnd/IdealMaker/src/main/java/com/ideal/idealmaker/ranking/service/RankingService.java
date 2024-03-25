package com.ideal.idealmaker.ranking.service;

/*
* 	작성자 : 정여민
* 	작성 일시 : 2024.03.21
* 	업데이트 : 2024.03.21
*	네용 : 동물상 랭킹순으로 반환처리
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ideal.idealmaker.ideal.domain.AnimalType;
import com.ideal.idealmaker.ranking.data.RankingResponseDto;
import com.ideal.idealmaker.ranking.repository.RankingRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
@Slf4j
public class RankingService {

	private final RankingRepository rankingRepository;


	/*
	* 	작성자 : 정여민
	* 	작성 일시 : 2024.03.21
	* 	업데이트 : 2024.03.21
	*
	* */

	// 동물상 랭킹 조회
	@Transactional
	public Map<String, List<RankingResponseDto>> findAnimalRanking(){

		Map<String, List<RankingResponseDto>> result = new HashMap<>();

		List<RankingResponseDto> rankingList = new ArrayList<>();

		List<AnimalType> rankingEntity = rankingRepository.findAll();

		// animalType entity를 DTO로 변환
		for (AnimalType animalType : rankingEntity) {
			RankingResponseDto dto = RankingResponseDto.from(animalType);
			rankingList.add(dto);
		}


		for (RankingResponseDto rankingResponseDto : rankingList) {
			System.out.println(rankingResponseDto.getAnimalType());
		}

		result.put("animalTypeRanking", rankingList);

		return result;
	}



}
