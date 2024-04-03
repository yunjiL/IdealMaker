package com.ideal.idealmaker.worldcup.dto;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class WorldcupDto {
    private Long idealId;
    private String idealURL;
    private String animalType; //동물상
    private Integer genderId;  //성별 id
}
