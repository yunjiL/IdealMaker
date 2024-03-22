package com.ideal.idealmaker.survey.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * 	작성자 : 정여민
 * 	작성 일시 : 2024.03.21
 * 	업데이트 : 2024.03.21
 *	네용 : 설문조사 임시용 컨트롤러
 * */

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class SurveySampleController {

	private final SurveyService surveyService;

	@GetMapping("/result/{idealId}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, String>> getResult(@PathVariable("idealId") Integer idealId){

		Map<String, String> response = new HashMap<>();


		response.put("idealURL", "https://i.imgur.com/azbkNYn.png");
		response.put("animalType", "여우상");
		response.put("animalImage", "https://i.imgur.com/Cpu7Fvy.png");


		return ResponseEntity.ok(response);
	}




}
