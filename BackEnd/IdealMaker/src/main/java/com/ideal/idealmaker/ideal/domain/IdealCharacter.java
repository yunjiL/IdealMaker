package com.ideal.idealmaker.ideal.domain;

import com.ideal.idealmaker.component.domain.Age;
import com.ideal.idealmaker.component.domain.Background;
import com.ideal.idealmaker.component.domain.ClothStyle;
import com.ideal.idealmaker.component.domain.Concept;
import com.ideal.idealmaker.component.domain.EyeStyle;
import com.ideal.idealmaker.component.domain.Face;
import com.ideal.idealmaker.component.domain.Gender;
import com.ideal.idealmaker.component.domain.HairLength;
import com.ideal.idealmaker.component.domain.HairStyle;
import com.ideal.idealmaker.component.domain.MakeUp;
import com.ideal.idealmaker.component.domain.SkinColor;

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
@Getter @Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IdealCharacter {

	@Id
	@Column(name = "character_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gender_id")
	private Gender gender;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "age_id")
	private Age age;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conept_id")
	private Concept concept;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "background_id")
	private Background background;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cloth_style_id")
	private ClothStyle clothStyle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "face_id")
	private Face face;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skin_color_id")
	private SkinColor skinColor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eye_style_id")
	private EyeStyle eyeStyle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hair_style_id")
	private HairStyle hairStyle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hair_length_id")
	private HairLength hairLength;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "make_up_id")
	private MakeUp makeUp;

}
