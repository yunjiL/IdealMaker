package com.ideal.idealmaker.ranking.data;

import com.ideal.idealmaker.ideal.domain.AnimalType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class RankingResponseDto {

	private String animalType;

	private String animalImage;

	private int chooseNum;


	public static RankingResponseDto from(AnimalType animalType){
		return RankingResponseDto.builder()
			.animalType(animalType.getType())
			.animalImage(animalType.getTypeURL())
			.chooseNum(animalType.getChooseNum())
			.build();
	}
}
