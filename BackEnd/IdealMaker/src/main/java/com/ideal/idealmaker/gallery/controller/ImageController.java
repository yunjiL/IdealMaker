package com.ideal.idealmaker.gallery.controller;


import com.ideal.idealmaker.gallery.data.ImageDTO;
import com.ideal.idealmaker.gallery.domain.model.Image;
import com.ideal.idealmaker.gallery.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }


    // 이미지 전체 조회
    @GetMapping("/api/gallery")
    public ResponseEntity<Page<ImageDTO>> getAllImages(Pageable pageable) {
        Page<Image> images = imageService.findAllImages(pageable);
        Page<ImageDTO> dtoPage = images.map(this::convertToDto);
        return ResponseEntity.ok(dtoPage);
    }

    // 이미지 상세 조회
    @GetMapping("/api/gallery/{idealId}")
    public ResponseEntity<ImageDTO> getImageById(@PathVariable Long idealId) {
        Image image = imageService.findImageById(idealId);
        if (image != null) {
            ImageDTO imageDTO = convertToDto(image);
            return ResponseEntity.ok(imageDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 동물상 필터링 검색
    @GetMapping("/api/gallery/search")
    public ResponseEntity<Page<ImageDTO>> findByAnimalType(@RequestParam String animalType, Pageable pageable) {
        Page<Image> images = imageService.findByAnimalType(animalType, pageable);
        Page<ImageDTO> dtoPage = images.map(this::convertToDto);
        return ResponseEntity.ok(dtoPage);
    }

    // DTO 변환 메소드
    private ImageDTO convertToDto(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setIdealId(image.getIdealId());
        dto.setIdealURL(image.getIdealURL());
        dto.setAnimalType(image.getAnimalType());
        return dto;
    }



}