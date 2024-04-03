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
import com.ideal.idealmaker.ranking.dto.RankingResponseDto;
import com.ideal.idealmaker.ranking.mapper.RankingMapper;
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
	* 	업데이트 : 2024.03.25
	*
	* */

	// 동물상 랭킹 조회
	@Transactional
	public Map<String, List<RankingResponseDto>> findAnimalRanking(){

		Map<String, List<RankingResponseDto>> result = new HashMap<>();

		List<RankingResponseDto> rankingList = new ArrayList<>();

		List<AnimalType> rankingEntity = new ArrayList<>();

		// 에외처리 
		try{
			rankingEntity = rankingRepository.findAll();
		}catch(Exception e) {	// 후에 바꿀 것
			throw new RuntimeException();
		}

		// 조회된 데이터가 없으면
		if(rankingEntity.isEmpty()){
			RankingResponseDto dto = new RankingResponseDto(null, null, 0);

		}else{	// 데이터가 존재하면
			// animalType entity를 DTO로 변환
			for (AnimalType animalType : rankingEntity) {
				RankingResponseDto dto = RankingMapper.toDto(animalType);
				rankingList.add(dto);
			}
			for (RankingResponseDto rankingResponseDto : rankingList) {
				System.out.println(rankingResponseDto.getAnimalType());
			}
			result.put("animalTypeRanking", rankingList);
		}


		return result;
	}



}
