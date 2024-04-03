package com.ideal.idealmaker.Dalle.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"url"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Datum {
	@JsonProperty("url")
	public String url;
}
