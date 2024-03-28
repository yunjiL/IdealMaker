package com.ideal.idealmaker.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.ideal.repository.IdealRepository;
import com.ideal.idealmaker.survey.dto.*;
import com.ideal.idealmaker.survey.mapper.SurveyMapper;
import com.ideal.idealmaker.survey.repository.*;

@Service @Slf4j
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService {

	private final AgeRepository ageRepository;
	private final BackgroundRepository backgroundRepository;
	private final ClothStyleRepository clothStyleRepository;
	private final ConceptRepository conceptRepository;
	private final EyeStyleRepository eyeStyleRepository;
	private final FaceRepository faceRepository;
	private final GenderRepository genderRepository;
	private final HairLengthRepository hairLengthRepository;
	private final HairStyleRepository hairStyleRepository;
	private final MakeUpRepository makeUpRepository;
	private final SkinColorRepository skinColorRepository;
	private final IdealRepository idealRepository;

	@Override
	public SurveyListDto readSurveyConceptList(Integer genderId) {

		Gender gender = genderRepository.findById(genderId)
			.orElseThrow(); // exception 추후 추가

		// 공통 설문조사 리스트
		SurveyDto[] survey = new SurveyDto[6];
		getCommonSurveyList(survey);

		// 컨셉 리스트
		List<SelectDto> concept = conceptRepository.findIdAndConcept(gender.getId());
		survey[5] = SurveyMapper.toSurveyDto("concept", "select", "컨셉을 선택해주세요", concept);

		return SurveyMapper.toSurveyListDto("concept", genderId, survey);
	}

	public SurveyListDto readSurveyCustomList(Integer genderId) {

		Gender gender = genderRepository.findById(genderId)
			.orElseThrow(); // exception 추후 추가

		SurveyDto[] survey;
		if (gender.getId() == 1) { // 남성일 경우
			survey = new SurveyDto[9];
		} else { // 여성일 경우
			survey = new SurveyDto[11];
		}
		
		getCommonSurveyList(survey); // 공통 설문조사 리스트
		getCustomSurveyList(survey, gender.getId()); // 커스텀 공통 설문 리스트
		if (gender.getId() == 2) { // 여성일 경우 추가되는 리스트
			List<SelectDto> hairLength = hairLengthRepository.findIdAndHairLength();
			survey[9] = SurveyMapper.toSurveyDto("hairLength", "select", "머리 길이를 선택해주세요", hairLength);
			List<SelectDto> makeUp = makeUpRepository.findIdAndMakeUp();
			survey[10] = SurveyMapper.toSurveyDto("makeUp", "select", "메이크업 스타일을 선택해주세요", makeUp);
		}

		return SurveyMapper.toSurveyListDto("custom", genderId, survey);
	}

	@Override
	public SurveyResultDto readSurveyResult(Long idealId) {
		SurveyResultDto surveyResultDto = new SurveyResultDto();
		String url = idealRepository.getById(idealId).getIdealURL();
		String animalType = "";
		surveyResultDto.setIdealUrl(url);
		surveyResultDto.setAnimalType(animalType);
		return surveyResultDto;
	}

	private void getCustomSurveyList(SurveyDto[] survey, Integer gender) {

		List<SelectDto> background = backgroundRepository.findIdAndBackground();
		survey[5] = SurveyMapper.toSurveyDto("background", "select", "배경을 선택해주세요", background);
		List<SelectDto> clothStyle = clothStyleRepository.findIdAndClothStyle();
		survey[6] = SurveyMapper.toSurveyDto("clothStyle", "select", "옷 스타일을 선택해주세요", clothStyle);
		List<SelectDto> hairStyle = hairStyleRepository.findIdAndHairStyle(gender);
		survey[7] = SurveyMapper.toSurveyDto("hairStyle", "select", "머리 스타일을 선택해주세요", hairStyle);
		survey[8] = SurveyMapper.toSurveyDto("hairColor", "color", "머리 색을 선택해주세요", null);
	}

	private void getCommonSurveyList(SurveyDto[] survey) {

		List<SelectDto> age = ageRepository.findIdAndAge();
		survey[0] = SurveyMapper.toSurveyDto("age", "select", "나이를 선택해주세요", age);
		List<SelectDto> faceShape = faceRepository.findIdAndFace();
		survey[1] = SurveyMapper.toSurveyDto("faceShape", "select", "얼굴형을 선택해주세요", faceShape);
		List<SelectDto> skinColor = skinColorRepository.findIdAndSkinColor();
		survey[2] = SurveyMapper.toSurveyDto("skinColor", "select", "피부색을 선택해주세요", skinColor);
		List<SelectDto> eyeStyle = eyeStyleRepository.findIdAndEyeStyle();
		survey[3] = SurveyMapper.toSurveyDto("eyeStyle", "select", "눈 모양을 선택해주세요", eyeStyle);
		survey[4] = SurveyMapper.toSurveyDto("pupilColor", "color", "눈동자 색을 선택해주세요", null);
	}
}
