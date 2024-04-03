package com.ideal.idealmaker.Dalle.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/api/survey")
public class DalleController {

	@Autowired
	private DalleService dalleService;

	@Autowired
	private FileS3UploadService fileS3UploadService;

	@PostMapping("/concept")
	public ResponseEntity<?> getConcept(@RequestBody ConceptDto conceptDto) {
		//db에 conceptDto 저장하면서 이상형 특징 테이블에서 character_id로 반환
		Integer characterId = dalleService.savePromptDTO(conceptDto);

		//프롬프트 생성
		String prompt = dalleService.makeConceptPrompt(conceptDto);
		log.debug(">>>>>>" + prompt);

		try {
			//사진 생성
			String imageUrl = dalleService.makeDalleImage(prompt);
			log.debug(">>>>>>" + characterId + " " + imageUrl);

			//사진을 S3 서버에 저장
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(Integer.toString(characterId), imageUrl);

			//동물상 PK를 가져오기
			Long animalFaceId = conceptDto.getEyeStyleId().longValue();

			//이상형 테이블에 저장을 하고 ideal_id를 반환
			Long idealId = dalleService.saveImage(characterId, animalFaceId, fileInfo);

			//동물상 테이블에 choose_Num 업데이트
			dalleService.updateAnimalType(animalFaceId);
			return ResponseEntity.ok().body(idealId);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}

	}

	// @PostMapping("/custom/{genderId}")
	// public ResponseEntity<?> getCustom(@RequestBody Object dto, @PathVariable("genderId") Long genderId) {
	//
	// 	try{
	// 		if(genderId == 1 && dto instanceof CustomManDto customManDto){
	// 			log.debug("{}" ,genderId);
	//
	// 			//db에 customManDto 저장하면서 ideal_pk 반환
	// 			Integer characterId = dalleService.savePromptDTO(customManDto);
	//
	// 			//프롬프트 생성
	// 			String prompt = dalleService.makeCustomMan(customManDto);
	// 			log.debug(prompt);
	//
	// 			//사진 생성
	// 			String imageUrl = dalleService.makeDalleImage(prompt);
	// 			//사진을 S3 서버에 저장
	// 			log.debug(">>>>>>"+characterId + " " + imageUrl);
	// 			Long animalFaceId = customManDto.getEyeStyleId().longValue();
	// 			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(),imageUrl);
	// 			Long idealId = dalleService.saveImage(characterId,animalFaceId,fileInfo);
	//
	// 			//동물상을 animalType 테이블에 저장
	// 			dalleService.updateAnimalType(animalFaceId);
	// 			return ResponseEntity.ok().body(idealId);
	// 		}
	// 		else if(genderId == 2 && dto instanceof CustomWomanDto customWomanDto) {
	// 			//db에 customWomanDto 저장하면서 ideal_pk 반환
	// 			Integer characterId = dalleService.savePromptDTO(customWomanDto);
	//
	// 			//프롬프트 생성
	// 			String prompt = dalleService.makeCustomWoman(customWomanDto);
	// 			log.debug(prompt);
	// 			//사진 생성
	//
	// 			String imageUrl = dalleService.makeDalleImage(prompt);
	// 			if (imageUrl != null) {
	// 				//사진을 S3 서버에 저장
	// 				log.debug(">>>>>>" + characterId + " " + imageUrl);
	// 				Long animalFaceId = customWomanDto.getEyeStyleId().longValue();
	// 				FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(), imageUrl);
	// 				Long idealId = dalleService.saveImage(characterId, animalFaceId, fileInfo);
	//
	// 				//동물상을 animalType 테이블에 저장
	// 				dalleService.updateAnimalType(animalFaceId);
	//
	// 				return ResponseEntity.ok().body(characterId);
	//
	// 			}
	// 		}
	// 	}catch (Exception e){
	// 		return ResponseEntity.notFound().build();
	// 	}
	//
	// 	return ResponseEntity.badRequest().build();
	// }
	//

	@PostMapping("/custom/1")
	public ResponseEntity<?> getCustomMan(@RequestBody CustomManDto customManDto) {
		//db에 customManDto 저장하면서 ideal_pk 반환
		Integer characterId = dalleService.savePromptDTO(customManDto);

		//프롬프트 생성
		String prompt = dalleService.makeCustomMan(customManDto);
		log.debug(prompt);

		try {
			//사진 생성
			String imageUrl = dalleService.makeDalleImage(prompt);
			//사진을 S3 서버에 저장
			log.debug(">>>>>>" + characterId + " " + imageUrl);
			Long animalFaceId = customManDto.getEyeStyleId().longValue();
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(), imageUrl);
			Long idealId = dalleService.saveImage(characterId, animalFaceId, fileInfo);

			//동물상을 animalType 테이블에 저장
			dalleService.updateAnimalType(animalFaceId);
			return ResponseEntity.ok().body(idealId);

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/custom/2")
	public ResponseEntity<?> getCustomWoman(@RequestBody CustomWomanDto customWomanDto) {
		//db에 customWomanDto 저장하면서 ideal_pk 반환
		Integer characterId = dalleService.savePromptDTO(customWomanDto);

		//프롬프트 생성
		String prompt = dalleService.makeCustomWoman(customWomanDto);
		log.debug(prompt);

		try {
			//사진 생성
			String imageUrl = dalleService.makeDalleImage(prompt);
			//사진을 S3 서버에 저장
			log.debug(">>>>>>" + characterId + " " + imageUrl);
			Long animalFaceId = customWomanDto.getEyeStyleId().longValue();
			FileInfoDto fileInfo = fileS3UploadService.uploadImageURL(characterId.toString(), imageUrl);
			Long idealId = dalleService.saveImage(characterId, animalFaceId, fileInfo);

			//동물상을 animalType 테이블에 저장
			dalleService.updateAnimalType(animalFaceId);
			return ResponseEntity.ok().body(idealId);

		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
