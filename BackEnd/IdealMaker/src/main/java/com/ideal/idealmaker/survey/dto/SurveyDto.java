package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {

	private String title;

	private String type;

	private String question;

	@Builder.Default
	private List<SelectDto> answers = new ArrayList<>();
}
