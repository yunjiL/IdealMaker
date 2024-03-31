package com.ideal.idealmaker.gallery.controller;

import com.ideal.idealmaker.gallery.dto.ImageDTO;
import com.ideal.idealmaker.gallery.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/gallery")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    // 이미지 전체 조회
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ImageDTO> getAllImages(Pageable pageable) {
        return imageService.findAllImages(pageable);
    }

    // 이미지 상세 조회
    @GetMapping("/{idealId}")
    @ResponseStatus(HttpStatus.OK)
    public ImageDTO getImageById(@PathVariable Long idealId) {
        return imageService.findImageById(idealId);
    }

    // 동물상 필터링 검색
    @GetMapping("/search/animal-type")
    @ResponseStatus(HttpStatus.OK)
    public Page<ImageDTO> findByAnimalType(@RequestParam String animalType, Pageable pageable) {
        return imageService.findByAnimalType(animalType, pageable);
    }

    // 성별 필터링 검색
    @GetMapping("/search/gender")
    @ResponseStatus(HttpStatus.OK)
    public Page<ImageDTO> findByGenderId(@RequestParam Integer genderId, Pageable pageable) {
        return imageService.findByGenderId(genderId, pageable);
    }
}
