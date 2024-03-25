package com.ideal.idealmaker.survey.service;

import com.ideal.idealmaker.survey.dto.SurveyListDto;

public interface SurveyService {

	SurveyListDto readSurveyConceptList(Integer genderId);

	SurveyListDto readSurveyCustomList(Integer genderId);
}
