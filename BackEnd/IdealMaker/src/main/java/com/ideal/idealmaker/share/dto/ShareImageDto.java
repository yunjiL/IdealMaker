package com.ideal.idealmaker.share.dto;

import com.ideal.idealmaker.ideal.domain.Ideal;

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

}
