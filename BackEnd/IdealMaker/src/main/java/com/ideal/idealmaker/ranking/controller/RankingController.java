package com.ideal.idealmaker.ranking.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

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

@Slf4j
@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

	private final SurveyService surveyService;

	@GetMapping("/")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, Object>> getAnimalRanking(){

		Map<String, Object> response = new HashMap<>();

		return ResponseEntity.ok(response);
	}




}
