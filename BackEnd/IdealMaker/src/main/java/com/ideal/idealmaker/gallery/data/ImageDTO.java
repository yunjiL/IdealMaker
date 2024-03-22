package com.ideal.idealmaker.gallery.data;

import com.ideal.idealmaker.gallery.domain.model.Image;

public class ImageDTO {
    private Long idealId;
    private String idealURL;
    private String animalType;

    // Getters and Setters

    public Long getIdealId() {
        return idealId;
    }

    public void setIdealId(Long idealId) {
        this.idealId = idealId;
    }

    public String getIdealURL() {
        return idealURL;
    }

    public void setIdealURL(String idealURL) {
        this.idealURL = idealURL;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    // 정적 변환 메소드
    public static ImageDTO fromEntity(Image image) {
        ImageDTO dto = new ImageDTO();
        dto.setIdealId(image.getIdealId());
        dto.setIdealURL(image.getIdealURL());
        dto.setAnimalType(image.getAnimalType());
        return dto;
    }
}
