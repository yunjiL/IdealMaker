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

import com.ideal.idealmaker.survey.dto.SurveyConceptListDto;
import com.ideal.idealmaker.survey.dto.SurveyCustomListDto;
import com.ideal.idealmaker.survey.service.SurveyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/survey")
@RequiredArgsConstructor
public class SurveySampleController {

	private final SurveyService surveyService;

	@GetMapping("/custom/{gender}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> getCustomSurveyList(@PathVariable("gender") Integer gender){

		Map<String, Object> response = new HashMap<>();

		// 성별 정보 설정
		Map<String, Object> genderInfo = new HashMap<>();
		genderInfo.put("genderId", gender);
		genderInfo.put("gender", gender == 1 ? "남성" : "여성");
		response.put("genderInfo", genderInfo);

		// 나이 리스트 설정
		List<Map<String, Object>> ageList = new ArrayList<>();
		Map<String, Object> age = new HashMap<>();
		age.put("ageId", 1);
		age.put("age", "20");
		ageList.add(age);
		response.put("ageList", ageList);

		// 얼굴 리스트 설정
		List<Map<String, Object>> faceShapeList = new ArrayList<>();
		Map<String, Object> face = new HashMap<>();
		face.put("faceId", 1);
		face.put("face", "갸름한 얼굴");
		faceShapeList.add(face);
		response.put("faceShapeList",faceShapeList);

		// 피부색 리스트 설정
		List<Map<String, Object>> skinColorList = new ArrayList<>();
		Map<String, Object> skinColor = new HashMap<>();
		skinColor.put("skinColorId", 1);
		skinColor.put("skinColor", "상아색");
		skinColorList.add(skinColor);
		response.put("skinColorList",skinColorList);

		// 눈 스타일 리스트 설정
		List<Map<String, Object>> eyeStyleList = new ArrayList<>();
		Map<String, Object> eyeStyle = new HashMap<>();
		eyeStyle.put("eyeStyleId", 1);
		eyeStyle.put("eyeStyle", "날카로운 눈");
		eyeStyleList.add(eyeStyle);
		response.put("eyeStyleList",eyeStyleList);

		// 배경 리스트 설정
		List<Map<String, Object>> backgroundList = new ArrayList<>();
		Map<String, Object> background = new HashMap<>();
		background.put("backgroundId", 1);
		background.put("background", "눈 내리는 삿포로");
		backgroundList.add(background);
		response.put("backgroundtList",backgroundList);

		// 옷 리스트 설정
		List<Map<String, Object>> clothList = new ArrayList<>();
		Map<String, Object> cloth= new HashMap<>();
		cloth.put("clothId", 1);
		cloth.put("cloth", "블레이저 자켓");
		clothList.add(cloth);
		response.put("clothList",clothList);

		// 머리스타일 리스트 설정
		List<Map<String, Object>> hairStyleList = new ArrayList<>();
		Map<String, Object> hairStyle= new HashMap<>();
		hairStyle.put("hairStyleId", gender == 1 ? 1 : 6);
		hairStyle.put("hairStyle", gender == 1 ? "말린머리" : "앞머리");
		hairStyleList.add(hairStyle);
		response.put("hairStyleList",hairStyleList);



		if (gender == 2) {
			// 머리 길이 리스트 설정
			List<Map<String, Object>> hairLengthList = new ArrayList<>();
			Map<String, Object> hairLength= new HashMap<>();
			hairLength.put("hairLengthId", 1);
			hairLength.put("hairLength", "짧은");
			hairLengthList.add(hairLength);
			response.put("hairLengthList",hairLengthList);

			// 메이크업 리스트 설정
			List<Map<String, Object>> makeUpList = new ArrayList<>();
			Map<String, Object> makeUp = new HashMap<>();
			makeUp.put("makeUpId", 1);
			makeUp.put("makeUp", "스모키");
			makeUpList.add(makeUp);
			response.put("makeUpList",makeUpList);
		} 



		response.put("pupilColor",null);
		response.put("hairColor",null);

		return ResponseEntity.ok(response);
	}

	@GetMapping("/concept/{gender}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, Object>> getConceptSurveyList(@PathVariable("gender") Integer gender){

		Map<String, Object> response = new HashMap<>();

		// 성별 정보 설정
		Map<String, Object> genderInfo = new HashMap<>();
		genderInfo.put("genderId", gender);
		genderInfo.put("gender", gender == 1 ? "남성" : "여성");
		response.put("genderInfo", genderInfo);

		// 나이 리스트 설정
		List<Map<String, Object>> ageList = new ArrayList<>();
		Map<String, Object> age = new HashMap<>();
		age.put("ageId", 1);
		age.put("age", "20");
		ageList.add(age);
		response.put("ageList", ageList);

		// 얼굴 리스트 설정
		List<Map<String, Object>> faceShapeList = new ArrayList<>();
		Map<String, Object> face = new HashMap<>();
		face.put("faceId", 1);
		face.put("face", "갸름한 얼굴");
		faceShapeList.add(face);
		response.put("faceShapeList",faceShapeList);

		// 피부색 리스트 설정
		List<Map<String, Object>> skinColorList = new ArrayList<>();
		Map<String, Object> skinColor = new HashMap<>();
		skinColor.put("skinColorId", 1);
		skinColor.put("skinColor", "상아색");
		skinColorList.add(skinColor);
		response.put("skinColorList",skinColorList);

		// 눈 스타일 리스트 설정
		List<Map<String, Object>> eyeStyleList = new ArrayList<>();
		Map<String, Object> eyeStyle = new HashMap<>();
		eyeStyle.put("eyeStyleId", 1);
		eyeStyle.put("eyeStyle", "날카로운 눈");
		eyeStyleList.add(eyeStyle);
		response.put("eyeStyleList",eyeStyleList);

		// 컨셉 리스트 설정
		List<Map<String, Object>> conceptList = new ArrayList<>();
		Map<String, Object> concept = new HashMap<>();
		concept.put("conceptId", gender == 1 ? 1 : 2);
		concept.put("concept", gender == 1 ? "발레리노" : "발레리나");
		conceptList.add(concept);
		response.put("conceptList",conceptList);

		response.put("pupilColor",null);


		return ResponseEntity.ok(response);
	}


}
