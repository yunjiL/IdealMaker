package com.ideal.idealmaker.Dalle.util;

import org.springframework.stereotype.Component;

import com.ideal.idealmaker.Dalle.dto.ConceptDto;
import com.ideal.idealmaker.component.domain.Age;
import com.ideal.idealmaker.component.domain.Concept;
import com.ideal.idealmaker.component.domain.EyeStyle;
import com.ideal.idealmaker.component.domain.Face;
import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.component.domain.SkinColor;
import com.ideal.idealmaker.ideal.domain.IdealCharacter;
import com.ideal.idealmaker.survey.repository.AgeRepository;
import com.ideal.idealmaker.survey.repository.ConceptRepository;
import com.ideal.idealmaker.survey.repository.EyeStyleRepository;
import com.ideal.idealmaker.survey.repository.FaceRepository;
import com.ideal.idealmaker.survey.repository.GenderRepository;
import com.ideal.idealmaker.survey.repository.SkinColorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ConceptMapper {

	private final GenderRepository genderRepository;
	private final AgeRepository ageRepository;
	private final FaceRepository faceRepository;
	private final SkinColorRepository skinColorRepository;
	private final EyeStyleRepository eyeStyleRepository;
	private final ConceptRepository conceptRepository;

	public IdealCharacter ConceptDtoToEntity(ConceptDto conceptDto) {
		Gender gender = genderRepository.getById(conceptDto.getGenderId());
		Age age = ageRepository.getById(conceptDto.getAgeId());
		Face face = faceRepository.getById(conceptDto.getFaceShapeId());
		SkinColor skinColor = skinColorRepository.getById(conceptDto.getSkinColorId());
		EyeStyle eyeStyle = eyeStyleRepository.getById(conceptDto.getEyeStyleId());
		Concept concept = conceptRepository.getById(conceptDto.getConceptId());

		return IdealCharacter.builder()
			.gender(gender)
			.age(age)
			.face(face)
			.skinColor(skinColor)
			.eyeStyle(eyeStyle)
			.concept(concept)
			.build();
	}
}
