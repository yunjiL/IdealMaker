package com.ideal.idealmaker.share.mapper;

import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.share.dto.ShareImageDto;


/*
* 작성자 : 정여민
* 작성일시 : 2024.04.03
*
* */
public class ShareImageMapper {
	public static ShareImageDto toDto(Ideal ideal){
		return ShareImageDto.builder().idealURL(ideal.getIdealURL()).build();
	}
}
