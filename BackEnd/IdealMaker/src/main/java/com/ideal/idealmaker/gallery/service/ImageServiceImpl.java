package com.ideal.idealmaker.gallery.service;

import com.ideal.idealmaker.exception.ExceptionMessage;
import com.ideal.idealmaker.exception.IllegalExtensionException;
import com.ideal.idealmaker.gallery.dto.ImageDTO;
import com.ideal.idealmaker.gallery.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl (ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    //이미지 전체 조회 (페이지네이션)
    @Override
    public Page<ImageDTO> findAllImages(Pageable pageable) {
        return imageRepository.findAll(pageable);
    }

    //이미지 상세 조회 (idealId)
    @Override
    public ImageDTO findImageById(Long idealId) {
        return imageRepository.findById(idealId)
                .orElseThrow(() -> new IllegalExtensionException(ExceptionMessage.ENTITY_NOT_FOUND));
    }

    //동물상 필터링 검색 (선택하면 그 페이지에 해당 동물상만 나오게)
    @Override
    public Page<ImageDTO> findByAnimalType(String animalType, Pageable pageable) {
        return imageRepository.findByAnimalType(animalType, pageable);
    }

    //성별 필터링 검색 (선택하면 해당 성별만 나오게)
    @Override
    public Page<ImageDTO> findByGenderId(int genderId, Pageable pageable) {
        return imageRepository.findByGenderId(genderId,pageable);
    }


}
