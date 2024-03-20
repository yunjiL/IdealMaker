package com.ideal.idealmaker.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClothStyleDto {

	private Integer clothStyleId;

	private String clothStyle;
}
