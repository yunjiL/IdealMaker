package com.ideal.idealmaker.survey.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.survey.dto.SurveyListDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/survey")
@RequiredArgsConstructor

public class SurveyController {

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public SurveyListDto getSurveyList(@RequestParam(value = "gender") String gender,
										@RequestParam(value = "type") String type) {



		return null;
	}


}
