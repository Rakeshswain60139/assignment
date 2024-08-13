package com.rakesh.assignment.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "continent")
public class ContinentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String code;
	private String name;
	private Long areaSqKm;
	private Long population;
	private Integer countries;

	@OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LinesEntity> lines;

	@OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OceansEntity> oceans;

	@OneToMany(mappedBy = "continent", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<DevelopedCountryEntity> developedCountries;
}
