package com.ideal.idealmaker.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.ideal.idealmaker.survey.dto.*;
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
	private final MakeUpRepository makeUpRepository;
	private final SkinColorRepository skinColorRepository;

	public SurveyConceptListDto readSurveyConceptList(String gender) {

		List<SelectDto> ageList = ageRepository.findIdAndAge();


		return null;
	}
}
