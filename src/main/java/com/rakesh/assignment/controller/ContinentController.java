package com.rakesh.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rakesh.assignment.dto.ContinentJsonResponseDto;
import com.rakesh.assignment.entity.ContinentEntity;
import com.rakesh.assignment.entity.DevelopedCountryEntity;
import com.rakesh.assignment.entity.LinesEntity;
import com.rakesh.assignment.entity.OceansEntity;
import com.rakesh.assignment.service.ContinentService;

@RestController
public class ContinentController {

	@Autowired
	private ContinentService continentService;

//	@PostMapping("/rks")
//	public ContinentEntity addContinent(@RequestBody ContinentEntity continent) {
//		return continentService.save(continent);
//	}

	private final String JSON_URL = "https://dummy-json.mock.beeceptor.com/continents";

//	public static void main(String[] args) {
//		ContinentController controller = new ContinentController();
//		controller.jsonRead();
//	}

	@PostMapping("/jsonRead")
	public ResponseEntity<String> jsonRead() {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("------------" + JSON_URL);
		ContinentJsonResponseDto[] responseArray = restTemplate.getForObject(JSON_URL,
				ContinentJsonResponseDto[].class);

		if (responseArray == null) {
			return ResponseEntity.ok("No value presnt");
		}

		for (ContinentJsonResponseDto response : responseArray) {
			ContinentEntity continent = new ContinentEntity();
			continent.setCode(response.getCode());
			continent.setName(response.getName());
			continent.setAreaSqKm(response.getAreaSqKm());
			continent.setPopulation(response.getPopulation());
			continent.setCountries(response.getCountries());

			continent.setLines(
					response.getLines().stream().map(line -> new LinesEntity(null, line, continent)).toList());

			continent.setOceans(
					response.getOceans().stream().map(ocean -> new OceansEntity(null, ocean, continent)).toList());

			continent.setDevelopedCountries(response.getDevelopedCountries().stream()
					.map(country -> new DevelopedCountryEntity(null, country, continent)).toList());

			continentService.save(continent);
		}
		return ResponseEntity.ok("Success");

	}

}
