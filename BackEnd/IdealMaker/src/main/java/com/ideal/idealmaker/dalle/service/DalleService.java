package com.ideal.idealmaker.Dalle.service;

import com.ideal.idealmaker.Dalle.domain.DalleResponse;
import com.ideal.idealmaker.Dalle.dto.ConceptDto;
import com.ideal.idealmaker.Dalle.dto.CustomManDto;
import com.ideal.idealmaker.Dalle.dto.CustomWomanDto;
import com.ideal.idealmaker.file.dto.FileInfoDto;

public interface DalleService {

	String makeConceptPrompt(ConceptDto conceptDto);

	String makeCustomMan(CustomManDto customManDto);

	String makeCustomWoman(CustomWomanDto customWomanDto);

	Integer savePromptDTO(Object dto);

	String makeDalleImage(String prompt);

	String extractFirstImageUrl(DalleResponse response);

	Long saveImage(Integer character_id,Long animalFaceId,FileInfoDto fileInfo);

	void updateAnimalType(Long animalFaceId);
}
