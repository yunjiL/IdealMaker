package com.ideal.idealmaker.share.data;

import com.ideal.idealmaker.ideal.domain.AnimalType;
import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.ranking.data.RankingResponseDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class ShareImageDto {
	private String idealURL;

	public static ShareImageDto from(Ideal ideal){
		return ShareImageDto.builder().idealURL(ideal.getIdelURL()).build();
	}

}
