package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class SurveyCustomListDto {

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class InnerParent{
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
		private List<background> backgroundList = new ArrayList<>();

		@Builder.Default
		private List<clothStyle> clothStyleList = new ArrayList<>();

		@Builder.Default
		private List<hairStyle> hairStyleList = new ArrayList<>();
	}

	@Getter
	@SuperBuilder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FemaleCustom extends InnerParent {

		private List<hairLength> hairLengthList;

		@Builder.Default
		private List<makeUp> makeUpList = new ArrayList<>();

		FemaleCustom(String type, String genderNm, List<age> ageList, List<face> faceList,
			List<skinColor> skinColorList,
			List<eyeStyle> eyeStyleList, List<background> backgroundList, List<clothStyle> clothStyleList,
			List<hairStyle> hairStyleList) {
			super(type, genderNm, ageList, faceList, skinColorList, eyeStyleList, backgroundList, clothStyleList,
				hairStyleList);
		}
	}

	@Data
	@Builder
	public static class maleCustom extends InnerParent {


	}

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

	private class background {
		Integer backgroundId;
		String background;
	}

	private class clothStyle {
		Integer clothStyleId;
		String clothStyle;
	}

	private class hairStyle {
		Integer hairStyleId;
		String hairStyle;
	}

	private class hairLength {
		Integer hairLengthId;
		String hairLength;
	}

	private class makeUp {
		Integer makeUpId;
		String makeUp;
	}

}

