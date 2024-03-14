package com.ideal.idealmaker.ideal.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class IdealAnimalType {

	@EmbeddedId
	private IdealAnimalTypeId idealAnimalTypeId;

	@ManyToOne
	@JoinColumn(name = "ideal_id")
	@MapsId("idealId")
	private Ideal ideal;

	@ManyToOne
	@JoinColumn(name = "animal_type_id")
	@MapsId("animalTypeId")
	private AnimalType animalType;

}
