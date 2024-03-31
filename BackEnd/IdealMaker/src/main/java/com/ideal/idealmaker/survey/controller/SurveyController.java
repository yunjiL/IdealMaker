package com.ideal.idealmaker.survey.controller;

import static com.ideal.idealmaker.exception.ExceptionMessage.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.exception.ExceptionMessage;
import com.ideal.idealmaker.exception.IllegalTypeException;
import com.ideal.idealmaker.survey.dto.SurveyListDto;
import com.ideal.idealmaker.survey.dto.SurveyResultDto;
import com.ideal.idealmaker.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/survey")	// 임시로 API 주소 바꾸기 위해 썼습니다.
@RequiredArgsConstructor
public class SurveyController {

	private final SurveyService surveyService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public SurveyListDto getSurveyList(@RequestParam(value = "type") String type
										,@RequestParam(value = "gender") Integer gender) {

		if (type.equals("concept")) {
			return surveyService.readSurveyConceptList(gender);
		} else if (type.equals("custom")) {
			return surveyService.readSurveyCustomList(gender);
		} else {
			throw new IllegalTypeException(TYPE_ILLEGAL);
		}
	}

	@GetMapping("/{idealId}")
	public SurveyResultDto getSurveyResult(@PathVariable("idealId") Long idealId){
		return surveyService.readSurveyResult(idealId);
	}
}
