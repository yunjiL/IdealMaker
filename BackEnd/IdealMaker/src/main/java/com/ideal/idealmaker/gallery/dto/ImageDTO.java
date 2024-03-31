package com.ideal.idealmaker.gallery.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ImageDTO {
    private Long idealId;
    private String idealURL;
    private String animalType; //동물상
    private int genderId;  //성별 id

}
