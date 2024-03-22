package com.ideal.idealmaker.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MakeUpDto {

	private Integer makeUpId;

	private String makeUp;
}
