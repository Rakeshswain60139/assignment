package com.rakesh.assignment.service.impl;

import org.springframework.stereotype.Service;

import com.rakesh.assignment.entity.ContinentEntity;
import com.rakesh.assignment.repository.ContinentRepository;
import com.rakesh.assignment.service.ContinentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContinentServiceImpl implements ContinentService {

	private final ContinentRepository continentRepository;

	@Override
	public ContinentEntity save(ContinentEntity continent) {
		return continentRepository.save(continent);
	}

}
