package com.ideal.idealmaker.gallery.service;

import com.ideal.idealmaker.exception.ExceptionMessage;
import com.ideal.idealmaker.exception.IllegalExtensionException;
import com.ideal.idealmaker.gallery.util.ImageMapper;
import com.ideal.idealmaker.ideal.domain.Ideal;
import com.ideal.idealmaker.gallery.dto.ImageDTO;
import com.ideal.idealmaker.gallery.repository.ImageRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Slf4j
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;
    //전체 조회
    @Override
    @Transactional(readOnly = true)
    public Page<ImageDTO> findAllImages(Pageable pageable) {
        return imageRepository.findAll(pageable)
                .map(imageMapper::toImageDTO);
    }

    //상세 조회
    @Override
    @Transactional(readOnly = true)
    public ImageDTO findImageById(Long idealId) {
        return imageRepository.findById(idealId)
                .map(imageMapper::toImageDTO)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found")); // 예외 처리 변경
    }

    //동물상 필터링 조회
    @Override
    @Transactional(readOnly = true)
    public Page<ImageDTO> findByAnimalType(String animalType, Pageable pageable) {
        return imageRepository.findByAnimalType(animalType, pageable)
                .map(imageMapper::toImageDTO);
    }

    //성별 필터링 조회
    @Override
    @Transactional(readOnly = true)
    public Page<ImageDTO> findByGenderId(Integer genderId, Pageable pageable) {
        return imageRepository.findByGenderId(genderId, pageable)
                .map(imageMapper::toImageDTO);
    }

}
