package com.ideal.idealmaker.Dalle.util;

import org.springframework.stereotype.Component;

import com.ideal.idealmaker.ideal.domain.AnimalType;
import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.ideal.domain.IdealCharacter;
import com.ideal.idealmaker.ideal.repository.AnimalTypeRepository;
import com.ideal.idealmaker.ideal.repository.IdealCharacterRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IdealMapper {
	private final IdealCharacterRepository idealCharacterRepository;
	private final AnimalTypeRepository animalTypeRepository;

	public Ideal toEntity(Integer idealId, Long animalTypeId, String url) {
		IdealCharacter idealCharacter = idealCharacterRepository.getById(idealId);
		AnimalType animalType = animalTypeRepository.getById(animalTypeId);
		return Ideal.builder().idealCharacter(idealCharacter).idealURL(url).idealRank(0).animalType(animalType).build();
	}
}
