package com.ideal.idealmaker.component.domain;

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
public class SkinColor {

	@Id
	@Column(name = "skin_color_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String skinColor;

	@Column(nullable = false)
	private String eng;

}
