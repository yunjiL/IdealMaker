package com.ideal.idealmaker.Dalle.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"data"
})

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DalleResponse {
	@JsonProperty("data")
	public List<Datum> data;
}
