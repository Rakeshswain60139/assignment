package com.rakesh.assignment.dto;

import java.util.List;

import lombok.Data;

@Data
public class ContinentJsonResponseDto {
	private String code;
	private String name;
	private Long areaSqKm;
	private Long population;
	private Integer countries;
	private List<String> lines;
	private List<String> oceans;
	private List<String> developedCountries;
}
