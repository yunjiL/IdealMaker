package com.ideal.idealmaker.survey.dto;

import java.util.ArrayList;
import java.util.List;

import com.ideal.idealmaker.component.domain.EyeStyle;

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
	private List<AgeDto> ageList = new ArrayList<>();

	@Builder.Default
	private List<FaceDto> faceList = new ArrayList<>();

	@Builder.Default
	private List<SkinColorDto> skinColorList = new ArrayList<>();

	@Builder.Default
	private List<EyeStyleDto> eyeStyleList = new ArrayList<>();

	@Builder.Default
	private List<ConceptDto> conceptList = new ArrayList<>();
	
}
