package com.ideal.idealmaker.ideal.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ideal {

	@Id
	@Column(name = "ideal_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "character_id")
	private IdealCharacter idealCharacter;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "animal_type_id")
	private AnimalType animalType;

	private String idealURL;

	private Integer idealRank;

	private LocalDate createdAt;

}
