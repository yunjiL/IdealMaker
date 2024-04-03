package com.ideal.idealmaker.gallery.mapper;

import com.ideal.idealmaker.gallery.dto.ImageDto;
import com.ideal.idealmaker.ideal.domain.Ideal;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageDto toImageDTO(Ideal ideal) {
        return ImageDto.builder()
                .idealId(ideal.getId())
                .idealURL(ideal.getIdealURL())
                .animalType(ideal.getAnimalType().getType())
                .genderId(ideal.getIdealCharacter().getGender().getId())
                .build();
    }
}
