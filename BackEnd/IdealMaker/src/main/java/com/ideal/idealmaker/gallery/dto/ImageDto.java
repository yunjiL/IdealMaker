package com.ideal.idealmaker.gallery.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ImageDto {
    private Long idealId;
    private String idealURL;
    private String animalType; //동물상
    private Integer genderId;  //성별 id
}
