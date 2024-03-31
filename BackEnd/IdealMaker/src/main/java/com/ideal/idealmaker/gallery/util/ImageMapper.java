package com.ideal.idealmaker.gallery.util;

import com.ideal.idealmaker.gallery.dto.ImageDTO;
import com.ideal.idealmaker.ideal.domain.Ideal;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {

    public ImageDTO toImageDTO(Ideal ideal) {
        return ImageDTO.builder()
                .idealId(ideal.getId())
                .idealURL(ideal.getIdealURL())
                .animalType(ideal.getAnimalType().getType())
                .genderId(ideal.getIdealCharacter().getGender().getId())
                .build();
    }
}
