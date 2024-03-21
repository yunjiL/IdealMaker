package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import com.ideal.idealmaker.component.domain.HairLength;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

public class SurveyCustomListDto {

	@Getter
	@NoArgsConstructor
	@AllArgsConstructor
	@SuperBuilder
	public static class Custom {
		private String type;

		private String genderNm;

		@Builder.Default
		private List<AgeDto> ageList = new ArrayList<>();

		@Builder.Default
		private List<FaceDto> faceList = new ArrayList<>();

		@Builder.Default
		private List<SkinColorDto> skinColorList = new ArrayList<>();

		@Builder.Default
		private List<EyeStyleDto> eyeStyleList = new ArrayList<>();

		private String eyeColor;

		@Builder.Default
		private List<BackgroundDto> backgroundList = new ArrayList<>();

		@Builder.Default
		private List<ClothStyleDto> clothStyleList = new ArrayList<>();

		@Builder.Default
		private List<HairStyleDto> hairStyleList = new ArrayList<>();

		private String hairColor;
	}

	@Getter
	@SuperBuilder
	@AllArgsConstructor
	@NoArgsConstructor
	public static class FemaleCustom extends Custom {

		private List<HairLengthDto> hairLengthList;

		@Builder.Default
		private List<MakeUpDto> makeUpList = new ArrayList<>();
	}

}

