package com.ideal.idealmaker.survey.service;

import com.ideal.idealmaker.survey.dto.SurveyListDto;
import com.ideal.idealmaker.survey.dto.SurveyResultDto;

public interface SurveyService {

	SurveyListDto readSurveyConceptList(Integer genderId);

	SurveyListDto readSurveyCustomList(Integer genderId);

	SurveyResultDto readSurveyResult(Long idealId);
}
