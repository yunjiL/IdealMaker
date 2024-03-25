package com.ideal.idealmaker.ranking.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.ranking.data.RankingResponseDto;
import com.ideal.idealmaker.ranking.service.RankingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

	private final RankingService rankingService;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, List<RankingResponseDto>>> getAnimalRanking(){

		Map<String, List<RankingResponseDto>> response = new HashMap<>();

		response = rankingService.findAnimalRanking();

		return ResponseEntity.ok(response);
	}
}
