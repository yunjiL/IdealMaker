package com.ideal.idealmaker.ideal.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AnimalType {

	@Id
	@Column(name = "animal_type_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String type;

	private Integer chooseNum;

	private LocalDate updatedAt;

	private String typeURL;

}
