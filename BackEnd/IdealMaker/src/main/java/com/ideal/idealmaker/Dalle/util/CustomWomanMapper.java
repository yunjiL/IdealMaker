package com.ideal.idealmaker.Dalle.util;

import org.springframework.stereotype.Component;

import com.ideal.idealmaker.Dalle.dto.CustomWomanDto;
import com.ideal.idealmaker.component.domain.Age;
import com.ideal.idealmaker.component.domain.Background;
import com.ideal.idealmaker.component.domain.ClothStyle;
import com.ideal.idealmaker.component.domain.EyeStyle;
import com.ideal.idealmaker.component.domain.Face;
import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.component.domain.HairLength;
import com.ideal.idealmaker.component.domain.HairStyle;
import com.ideal.idealmaker.component.domain.MakeUp;
import com.ideal.idealmaker.component.domain.SkinColor;
import com.ideal.idealmaker.ideal.domain.IdealCharacter;
import com.ideal.idealmaker.survey.repository.AgeRepository;
import com.ideal.idealmaker.survey.repository.BackgroundRepository;
import com.ideal.idealmaker.survey.repository.ClothStyleRepository;
import com.ideal.idealmaker.survey.repository.EyeStyleRepository;
import com.ideal.idealmaker.survey.repository.FaceRepository;
import com.ideal.idealmaker.survey.repository.GenderRepository;
import com.ideal.idealmaker.survey.repository.HairLengthRepository;
import com.ideal.idealmaker.survey.repository.HairStyleRepository;
import com.ideal.idealmaker.survey.repository.MakeUpRepository;
import com.ideal.idealmaker.survey.repository.SkinColorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class CustomWomanMapper {
	private final GenderRepository genderRepository;
	private final AgeRepository ageRepository;
	private final FaceRepository faceRepository;
	private final SkinColorRepository skinColorRepository;
	private final EyeStyleRepository eyeStyleRepository;
	private final BackgroundRepository backgroundRepository;
	private final ClothStyleRepository clothStyleRepository;
	private final HairStyleRepository hairStyleRepository;
	private final HairLengthRepository hairLengthRepository;
	private final MakeUpRepository makeUpRepository;

	public IdealCharacter CustomWomanDtoToEntity(CustomWomanDto customWomanDto) {
		Gender gender = genderRepository.getById(customWomanDto.getGenderId());
		Age age = ageRepository.getById(customWomanDto.getAgeId());
		Face face = faceRepository.getById(customWomanDto.getFaceShapeId());
		SkinColor skinColor = skinColorRepository.getById(customWomanDto.getSkinColorId());
		EyeStyle eyeStyle = eyeStyleRepository.getById(customWomanDto.getEyeStyleId());
		Background background = backgroundRepository.getById(customWomanDto.getBackgroundId());
		ClothStyle clothStyle = clothStyleRepository.getById(customWomanDto.getClothStyleId());
		HairStyle hairStyle = hairStyleRepository.getById(customWomanDto.getHairStyleId());
		HairLength hairLength = hairLengthRepository.getById(customWomanDto.getHairLengthId());
		MakeUp makeUp = makeUpRepository.getById(customWomanDto.getMakeUpId());

		return IdealCharacter.builder()
			.gender(gender)
			.age(age)
			.face(face)
			.skinColor(skinColor)
			.eyeStyle(eyeStyle)
			.background(background)
			.clothStyle(clothStyle)
			.hairStyle(hairStyle)
			.hairLength(hairLength)
			.makeUp(makeUp)
			.build();
	}
}
