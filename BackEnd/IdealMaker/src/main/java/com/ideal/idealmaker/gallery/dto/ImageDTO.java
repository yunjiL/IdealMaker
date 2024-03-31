package com.ideal.idealmaker.gallery.dto;

import com.ideal.idealmaker.ideal.domain.Ideal;
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
    private Integer genderId;  //성별 id
}
