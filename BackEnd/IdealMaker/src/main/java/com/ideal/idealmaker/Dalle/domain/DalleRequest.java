package com.ideal.idealmaker.Dalle.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"model",
	"prompt",
	"n",
	"size"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DalleRequest {

	@JsonProperty("model")
	public String model;
	@JsonProperty("prompt")
	public String prompt;
	@JsonProperty("n")
	public Integer n;
	@JsonProperty("size")
	public String size;

}