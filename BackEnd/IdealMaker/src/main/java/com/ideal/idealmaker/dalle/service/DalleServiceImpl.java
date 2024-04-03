package com.ideal.idealmaker.Dalle.service;

import static com.ideal.idealmaker.exception.ExceptionMessage.*;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ideal.idealmaker.Dalle.domain.DalleRequest;
import com.ideal.idealmaker.Dalle.domain.DalleResponse;
import com.ideal.idealmaker.Dalle.domain.Datum;
import com.ideal.idealmaker.Dalle.dto.ConceptDto;
import com.ideal.idealmaker.Dalle.dto.CustomManDto;
import com.ideal.idealmaker.Dalle.dto.CustomWomanDto;
import com.ideal.idealmaker.Dalle.util.ConceptMapper;
import com.ideal.idealmaker.Dalle.util.CustomManMapper;
import com.ideal.idealmaker.Dalle.util.CustomWomanMapper;
import com.ideal.idealmaker.Dalle.util.IdealMapper;
import com.ideal.idealmaker.exception.IllegalException;
import com.ideal.idealmaker.file.dto.FileInfoDto;
import com.ideal.idealmaker.ideal.domain.AnimalType;
import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.ideal.domain.IdealCharacter;
import com.ideal.idealmaker.ideal.repository.AnimalTypeRepository;
import com.ideal.idealmaker.ideal.repository.IdealCharacterRepository;
import com.ideal.idealmaker.ideal.repository.IdealRepository;
import com.ideal.idealmaker.survey.repository.AgeRepository;
import com.ideal.idealmaker.survey.repository.BackgroundRepository;
import com.ideal.idealmaker.survey.repository.ClothStyleRepository;
import com.ideal.idealmaker.survey.repository.ConceptRepository;
import com.ideal.idealmaker.survey.repository.EyeStyleRepository;
import com.ideal.idealmaker.survey.repository.FaceRepository;
import com.ideal.idealmaker.survey.repository.GenderRepository;
import com.ideal.idealmaker.survey.repository.HairLengthRepository;
import com.ideal.idealmaker.survey.repository.HairStyleRepository;
import com.ideal.idealmaker.survey.repository.MakeUpRepository;
import com.ideal.idealmaker.survey.repository.SkinColorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class DalleServiceImpl implements DalleService {

	private final RestTemplate template;
	private final GenderRepository genderRepository;
	private final AgeRepository ageRepository;
	private final FaceRepository faceRepository;
	private final SkinColorRepository skinColorRepository;
	private final EyeStyleRepository eyeStyleRepository;
	private final ConceptRepository conceptRepository;
	private final BackgroundRepository backgroundRepository;
	private final ClothStyleRepository clothStyleRepository;
	private final HairStyleRepository hairStyleRepository;
	private final MakeUpRepository makeUpRepository;
	private final HairLengthRepository hairLengthRepository;
	private final IdealCharacterRepository idealCharacterRepository;
	private final IdealRepository idealRepository;
	private final AnimalTypeRepository animalTypeRepository;

	private final ConceptMapper conceptMapper;
	private final IdealMapper idealMapper;
	private final CustomManMapper customManMapper;
	private final CustomWomanMapper customWomanMapper;

	String url = "https://api.openai.com/v1/images/generations";
	String model = "dall-e-3";
	String size = "1792x1024";
	String detail = "full-body portrait, wide shot so it's bright like a picture and 4K definition, and focus on the person, ultra realistic, details, sharp, focus, detailed skin,handsome korean, draw only one person";

	@Override
	@Description("컨셉 프롬프트 제작")
	public String makeConceptPrompt(ConceptDto conceptDto) {
		//각 repository에서 prompt 내용 가져오기
		String genderPrompt = genderRepository.getById(conceptDto.getGenderId()).getEng();
		String agePrompt = ageRepository.getById(conceptDto.getAgeId()).getEng();
		String facePrompt = faceRepository.getById(conceptDto.getFaceShapeId()).getEng();
		String skinColorPrompt = skinColorRepository.getById(conceptDto.getSkinColorId()).getEng();
		String eyePrompt = eyeStyleRepository.getById(conceptDto.getEyeStyleId()).getEng();
		String pupilColorPrompt = conceptDto.getPupilColor();
		String conceptPrompt = conceptRepository.getById(conceptDto.getConceptId()).getEng();

		//프롬프트 조합
		String prompt = "gender : " + genderPrompt +
			", nation : korean idol" +
			", age : " + agePrompt +
			", face shape : " + facePrompt +
			", skin color : " + skinColorPrompt +
			", eye style : " + eyePrompt +
			", pupil color : " + pupilColorPrompt +
			", concept " + conceptPrompt +
			", " + detail;
		return prompt;
	}

	@Override
	@Description("커스텀 남자 프롬프트 제작")
	public String makeCustomMan(CustomManDto customManDto) {
		//각 repository에서 prompt 내용 가져오기
		String genderPrompt = genderRepository.getById(customManDto.getGenderId()).getEng();
		String agePrompt = ageRepository.getById(customManDto.getAgeId()).getEng();
		String facePrompt = faceRepository.getById(customManDto.getFaceShapeId()).getEng();
		String skinColorPrompt = skinColorRepository.getById(customManDto.getSkinColorId()).getEng();
		String eyeStylePrompt = eyeStyleRepository.getById(customManDto.getSkinColorId()).getEng();
		String pupilColorPrompt = customManDto.getPupilColor();
		String backgroundPrompt = backgroundRepository.getById(customManDto.getBackgroundId()).getEng();
		String clothPrompt = clothStyleRepository.getById(customManDto.getClothStyleId()).getEng();
		String hairStylePrompt = hairStyleRepository.getById(customManDto.getHairStyleId()).getEng();
		String hairColorPrompt = customManDto.getHairColor();

		//프롬프트 조합
		String prompt = "gender : " + genderPrompt +
			", nation : korean idol" +
			", age : " + agePrompt +
			", face shape : " + facePrompt +
			", skin color: " + skinColorPrompt +
			", eye style" + eyeStylePrompt +
			", pupil color : " + pupilColorPrompt +
			", background : " + backgroundPrompt +
			", cloth : " + clothPrompt +
			", hair style : " + hairStylePrompt +
			", hair color : " + hairColorPrompt +
			", " + detail;
		return prompt;
	}


	@Override
	@Description("커스텀 여자 프롬프트 제작")
	public String makeCustomWoman(CustomWomanDto customWomanDto) {
		//각 repository에서 prompt 내용 가져오기
		String genderPrompt = genderRepository.getById(customWomanDto.getGenderId()).getEng();
		String agePrompt = ageRepository.getById(customWomanDto.getAgeId()).getEng();
		String facePrompt = faceRepository.getById(customWomanDto.getFaceShapeId()).getEng();
		String skinColorPrompt = skinColorRepository.getById(customWomanDto.getSkinColorId()).getEng();
		String eyeStylePrompt = eyeStyleRepository.getById(customWomanDto.getSkinColorId()).getEng();
		String pupilColorPrompt = customWomanDto.getPupilColor();
		String makeUpPrompt = makeUpRepository.getById(customWomanDto.getMakeUpId()).getEng();
		String backgroundPrompt = backgroundRepository.getById(customWomanDto.getBackgroundId()).getEng();
		String clothPrompt = clothStyleRepository.getById(customWomanDto.getClothStyleId()).getEng();
		String hairStylePrompt = hairStyleRepository.getById(customWomanDto.getHairStyleId()).getEng();
		String hairColorPrompt = customWomanDto.getHairColor();
		String hairLengthPrompt = hairLengthRepository.getById(customWomanDto.getHairLengthId()).getEng();

		//프롬프트 조합
		String prompt = "gender : " + genderPrompt +
			", nation : korean idol" +
			", age : " + agePrompt +
			", face shape : " + facePrompt +
			", skin color: " + skinColorPrompt +
			", eye style" + eyeStylePrompt +
			", pupil color : " + pupilColorPrompt +
			", background : " + backgroundPrompt +
			", cloth : " + clothPrompt +
			", hair style : " + hairStylePrompt +
			", hair color : " + hairColorPrompt +
			", hair length : " + hairLengthPrompt +
			", make-up : " + makeUpPrompt +
			", " + detail;
		return prompt;
	}

	@Override
	@Description("DTO 저장")
	public Integer savePromptDTO(Object dto) {
		IdealCharacter result;
		if(dto instanceof ConceptDto){
			result = idealCharacterRepository.save(conceptMapper.ConceptDtoToEntity((ConceptDto)dto));
			return result.getId();
		} else if (dto instanceof CustomManDto) {
			result = idealCharacterRepository.save(customManMapper.CustomManDtoToEntity((CustomManDto)dto));
			return result.getId();
		} else if (dto instanceof CustomWomanDto) {
			result = idealCharacterRepository.save(customWomanMapper.CustomWomanDtoToEntity((CustomWomanDto)dto));
			return result.getId();
		} else {
			throw new IllegalException(DTO_NOT_FOUND);
		}
	}

	@Override
	@Description("이상형 테이블에 characterId, animalTypeId, findInfoDTO 저장")
	public Long saveImage(Integer characterId,Long animalTypeId, FileInfoDto fileInfo) {
		Ideal result = idealRepository.save(idealMapper.toEntity(characterId,animalTypeId, fileInfo.getFileURL()));
		return result.getId();
	}

	@Description("달리 이미지 생성")
	@Override
	public String makeDalleImage(String prompt) {
		//이미지 생성
		DalleRequest request = new DalleRequest();
		request.setModel(model);
		request.setPrompt(prompt);
		request.setN(1);
		request.setSize(size);

		try{
			//이미지 URL 생성
			String imgUrl = extractFirstImageUrl(template.postForObject(url, request, DalleResponse.class));
			return imgUrl;
		}catch (Exception e){
			throw new IllegalException(URL_NOT_FOUND);
		}

	}

	@Override
	@Transactional	//트랜잭션으로 가둬줘야 변경 감지 가능
	@Description("동물상 테이블 choose_num 업데이트")
	public void updateAnimalType(Long animalFaceId) {

		//DB에서 animalFaceId 값을 기준으로 데이터를 찾는다 (영속화)
		Optional<AnimalType> animalType = animalTypeRepository.findById(animalFaceId);

		//만약 해당 값이 존재한다면 전달받은 ChooseNum으로 set을 함
		animalType.ifPresent(value -> {value.setChooseNum(value.getChooseNum() + 1);value.setUpdatedAt(LocalDate.now());});
	}

	@Description("이미지 url 추출")
	@Override
	public String extractFirstImageUrl(DalleResponse response) {
		if (response != null && response.getData() != null && !response.getData().isEmpty()) {
			Datum firstDatum = response.getData().get(0);
			return firstDatum.getUrl();
		}else {
			throw new IllegalException(URL_NOT_FOUND);
		}
	}

}
