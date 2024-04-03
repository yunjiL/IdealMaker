package com.ideal.idealmaker.ranking.mapper;

import com.ideal.idealmaker.ideal.domain.AnimalType;
import com.ideal.idealmaker.ranking.dto.RankingResponseDto;


/*
 * 작성자 : 정여민
 * 작성일시 : 2024.04.03
 *
 * */
public class RankingMapper {
	public static RankingResponseDto toDto(AnimalType animalType){
		return RankingResponseDto.builder()
			.animalType(animalType.getType())
			.animalImage(animalType.getTypeURL())
			.chooseNum(animalType.getChooseNum())
			.build();
	}
}
