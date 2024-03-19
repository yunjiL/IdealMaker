package com.ideal.idealmaker.ideal.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter @Builder
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class IdealAnimalTypeId implements Serializable {

	@Column(name = "ideal_id")
	private Long idealId;

	@Column(name = "animal_type_id")
	private Integer animalTypeId;
}
