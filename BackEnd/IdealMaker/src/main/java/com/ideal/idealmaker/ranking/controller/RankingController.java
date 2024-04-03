package com.ideal.idealmaker.ranking.controller;

import java.util.Map;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.ranking.dto.RankingResponseDto;
import com.ideal.idealmaker.ranking.service.RankingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
 * 	작성자 : 정여민
 * 	작성 일시 : 2024.03.21
 * 	업데이트 : 2024.03.25
 *
 * */


@Slf4j
@RestController
@RequestMapping("/api/ranking")
@RequiredArgsConstructor
public class RankingController {

	private final RankingService rankingService;

	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public Map<String, List<RankingResponseDto>> getAnimalRanking(){
		return rankingService.findAnimalRanking();
	}
}
