package com.ideal.idealmaker.Dalle.util;

import org.springframework.stereotype.Component;

import com.ideal.idealmaker.Dalle.dto.CustomManDto;
import com.ideal.idealmaker.component.domain.Age;
import com.ideal.idealmaker.component.domain.Background;
import com.ideal.idealmaker.component.domain.ClothStyle;
import com.ideal.idealmaker.component.domain.EyeStyle;
import com.ideal.idealmaker.component.domain.Face;
import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.component.domain.HairStyle;
import com.ideal.idealmaker.component.domain.SkinColor;
import com.ideal.idealmaker.ideal.domain.IdealCharacter;
import com.ideal.idealmaker.survey.repository.AgeRepository;
import com.ideal.idealmaker.survey.repository.BackgroundRepository;
import com.ideal.idealmaker.survey.repository.ClothStyleRepository;
import com.ideal.idealmaker.survey.repository.EyeStyleRepository;
import com.ideal.idealmaker.survey.repository.FaceRepository;
import com.ideal.idealmaker.survey.repository.GenderRepository;
import com.ideal.idealmaker.survey.repository.HairStyleRepository;
import com.ideal.idealmaker.survey.repository.SkinColorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component

public class CustomManMapper {
	private final GenderRepository genderRepository;
	private final AgeRepository ageRepository;
	private final FaceRepository faceRepository;
	private final SkinColorRepository skinColorRepository;
	private final EyeStyleRepository eyeStyleRepository;
	private final BackgroundRepository backgroundRepository;
	private final ClothStyleRepository clothStyleRepository;
	private final HairStyleRepository hairStyleRepository;

	public IdealCharacter CustomManDtoToEntity(CustomManDto customManDto) {
		Gender gender = genderRepository.getById(customManDto.getGenderId());
		Age age = ageRepository.getById(customManDto.getAgeId());
		Face face = faceRepository.getById(customManDto.getFaceShapeId());
		SkinColor skinColor = skinColorRepository.getById(customManDto.getSkinColorId());
		EyeStyle eyeStyle = eyeStyleRepository.getById(customManDto.getEyeStyleId());
		Background background = backgroundRepository.getById(customManDto.getBackgroundId());
		ClothStyle clothStyle = clothStyleRepository.getById(customManDto.getClothStyleId());
		HairStyle hairStyle = hairStyleRepository.getById(customManDto.getHairStyleId());
		return IdealCharacter.builder()
			.gender(gender)
			.age(age)
			.face(face)
			.skinColor(skinColor)
			.eyeStyle(eyeStyle)
			.background(background)
			.clothStyle(clothStyle)
			.hairStyle(hairStyle)
			.build();
	}
}
