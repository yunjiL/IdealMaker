package com.ideal.idealmaker.gallery.mapper;

import com.ideal.idealmaker.gallery.data.ImageDTO;
import com.ideal.idealmaker.gallery.domain.model.Image;

public class ImageMapper {

    // Entity에서 DTO로 변환
    public static ImageDTO toDto(Image image) {
        if (image == null) {
            return null;
        }

        ImageDTO dto = new ImageDTO();
        dto.setIdealId(image.getIdealId());
        dto.setIdealURL(image.getIdealURL());
        dto.setAnimalType(image.getAnimalType());

        return dto;
    }

    // DTO에서 Entity로 변환 (사용할 경우)
    public static Image toEntity(ImageDTO dto) {
        if (dto == null) {
            return null;
        }

        Image image = new Image();
        image.setIdealId(dto.getIdealId());
        image.setIdealURL(dto.getIdealURL());
        image.setAnimalType(dto.getAnimalType());

        return image;
    }
}
