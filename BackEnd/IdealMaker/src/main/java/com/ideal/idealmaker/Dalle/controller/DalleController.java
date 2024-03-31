package com.ideal.idealmaker.Dalle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ideal.idealmaker.Dalle.dto.ConceptDto;
import com.ideal.idealmaker.Dalle.dto.CustomManDto;
import com.ideal.idealmaker.Dalle.dto.CustomWomanDto;
import com.ideal.idealmaker.Dalle.service.DalleService;
import com.ideal.idealmaker.file.dto.FileInfoDto;
import com.ideal.idealmaker.file.service.FileS3UploadService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class DalleController {

	@Autowired
	private DalleService dalleService;

	@Autowired
	private FileS3UploadService fileS3UploadService;

	@PostMapping("/survey/concept")
	public ResponseEntity<?> getConcept(@RequestBody ConceptDto conceptDto) {
		//db에 conceptDto 저장하면서 ideal_pk 반환
		Integer characterId = dalleService.savePromptDTO(conceptDto);

		//프롬프트 생성
		String prompt = dalleService.makeConceptPrompt(conceptDto);
		log.debug(prompt);

		//사진 생성
		String imageUrl = dalleService.makeDalleImage(prompt);
		log.debug(imageUrl);

		if (imageUrl != null) {
			//사진을 S3 서버에 저장
			log.debug(">>>>>>"+characterId + " " + imageUrl);
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(),imageUrl);
			Long animalFaceId = conceptDto.getEyeStyleId().longValue();
			Long idealId = dalleService.saveImage(characterId,animalFaceId,fileInfo);

			//동물상을 animalType 테이블에 저장
			dalleService.updateAnimalType(animalFaceId);

			return ResponseEntity.ok().body(idealId);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@PostMapping("/survey/custom/1")
	public ResponseEntity<?> getCustomMan(@RequestBody CustomManDto customManDto) {
		//db에 customManDto 저장하면서 ideal_pk 반환
		Integer characterId = dalleService.savePromptDTO(customManDto);

		//프롬프트 생성
		String prompt = dalleService.makeCustomMan(customManDto);
		log.debug(prompt);

		//사진 생성
		String imageUrl = dalleService.makeDalleImage(prompt);
		if (imageUrl != null) {
			//사진을 S3 서버에 저장
			log.debug(">>>>>>"+characterId + " " + imageUrl);
			Long animalFaceId = customManDto.getEyeStyleId().longValue();
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(),imageUrl);
			Long idealId = dalleService.saveImage(characterId,animalFaceId,fileInfo);

			//동물상을 animalType 테이블에 저장
			dalleService.updateAnimalType(animalFaceId);
			return ResponseEntity.ok().body(idealId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/survey/custom/2")
	public ResponseEntity<?> getCustomWoman(@RequestBody CustomWomanDto customWomanDto) {
		//db에 customWomanDto 저장하면서 ideal_pk 반환
		Integer characterId = dalleService.savePromptDTO(customWomanDto);

		//프롬프트 생성
		String prompt = dalleService.makeCustomWoman(customWomanDto);
		log.debug(prompt);

		//사진 생성
		String imageUrl = dalleService.makeDalleImage(prompt);
		if (imageUrl != null) {
			//사진을 S3 서버에 저장
			log.debug(">>>>>>"+characterId + " " + imageUrl);
			Long animalFaceId = customWomanDto.getEyeStyleId().longValue();
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(),imageUrl);
			Long idealId = dalleService.saveImage(characterId,animalFaceId,fileInfo);

			//동물상을 animalType 테이블에 저장
			dalleService.updateAnimalType(animalFaceId);

			return ResponseEntity.ok().body(characterId);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
