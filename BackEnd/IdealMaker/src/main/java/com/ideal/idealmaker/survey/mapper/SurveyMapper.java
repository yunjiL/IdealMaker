package com.ideal.idealmaker.survey.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideal.idealmaker.survey.dto.SelectDto;
import com.ideal.idealmaker.survey.dto.SurveyDto;
import com.ideal.idealmaker.survey.dto.SurveyListDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SurveyMapper {

	public static SurveyListDto toSurveyListDto(String type, Integer gender, SurveyDto[] questions) {
		return  SurveyListDto.builder()
						.type(type)
						.gender(gender)
						.questions(questions)
						.build();
	}

	public static SurveyDto toSurveyDto(String title, String type, String question, List<SelectDto> answers) {
		return SurveyDto.builder()
					  .title(title)
					  .type(type)
					  .question(question)
					  .answers(answers)
					  .build();
	}
}
