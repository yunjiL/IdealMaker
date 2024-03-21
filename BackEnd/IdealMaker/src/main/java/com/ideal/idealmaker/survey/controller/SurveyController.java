package com.ideal.idealmaker.survey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.survey.dto.SurveyConceptListDto;
import com.ideal.idealmaker.survey.dto.SurveyCustomListDto;
import com.ideal.idealmaker.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/survey2")	// 임시로 API 주소 바꾸기 위해 썼습니다.
@RequiredArgsConstructor
public class SurveyController {

	private final SurveyService surveyService;

	@GetMapping("/custom/{gender}")
	@ResponseStatus(HttpStatus.OK)
	public SurveyCustomListDto getCustomSurveyList(@PathVariable(value = "gender") String gender) {

		SurveyCustomListDto.FemaleCustom female = new SurveyCustomListDto.FemaleCustom();

		return null;
	}

	@GetMapping("/concept/{gender}")
	@ResponseStatus(HttpStatus.OK)
	public SurveyConceptListDto getConceptSurveyList(@PathVariable(value = "gender") String gender) {

		SurveyCustomListDto.FemaleCustom female = new SurveyCustomListDto.FemaleCustom();

		return null;
	}
}
