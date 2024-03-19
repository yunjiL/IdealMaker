package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SurveyConceptListDto {

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

	@Builder.Default
	private List<concept> conceptList = new ArrayList<>();

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

	private class concept {
		Integer conceptId;
		String concept;
	}

}
