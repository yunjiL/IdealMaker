package com.ideal.idealmaker.gallery.data;

import com.ideal.idealmaker.gallery.domain.Image;

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

}
