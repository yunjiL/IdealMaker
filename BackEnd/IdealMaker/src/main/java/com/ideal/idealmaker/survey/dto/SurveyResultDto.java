package com.ideal.idealmaker.survey.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyResultDto {
	@JsonProperty("idealUrl")
	private String idealUrl;
	@JsonProperty("animalType")
	private String animalType;
}
