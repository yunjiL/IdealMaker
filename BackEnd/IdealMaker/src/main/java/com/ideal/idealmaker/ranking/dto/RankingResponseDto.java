package com.ideal.idealmaker.ranking.dto;

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

}
