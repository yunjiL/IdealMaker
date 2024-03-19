package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class SurveyListDto {

	private String type;

	private String genderNm;

	@Builder.Default
	private List<age> ageList = new ArrayList<>();

	@Builder.Default
	private List<face> faceList = new ArrayList<>();

	@Builder.Default
	private List<skinColor> skinColorList = new ArrayList<>();

	@Builder.Default
	private List<eyeStyle> eyeStyleList = new ArrayList<>();

	private class age {
		Integer ageId;
		String age;
	}

	private class face {
		Integer faceId;
		String face;
	}

	private class skinColor {
		Integer skinColorId;
		String skinColor;
	}

	private class eyeStyle {
		Integer eyeStyleId;
		String eyeStyle;
	}
}

