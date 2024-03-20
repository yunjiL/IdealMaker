package com.ideal.idealmaker.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ideal.idealmaker.component.domain.*;
import com.ideal.idealmaker.survey.dto.SurveyConceptListDto;
import com.ideal.idealmaker.survey.repository.AgeRepository;
import com.ideal.idealmaker.survey.repository.BackgroundRepository;
import com.ideal.idealmaker.survey.repository.ClothStyleRepository;
import com.ideal.idealmaker.survey.repository.ConceptRepository;
import com.ideal.idealmaker.survey.repository.EyeStyleRepository;
import com.ideal.idealmaker.survey.repository.FaceRepository;
import com.ideal.idealmaker.survey.repository.GenderRepository;
import com.ideal.idealmaker.survey.repository.HairLengthRepository;
import com.ideal.idealmaker.survey.repository.MakeUpRepository;
import com.ideal.idealmaker.survey.repository.SkinColorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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

		List<Age> ageList = ageRepository.findAll();


		return null;
	}
}
