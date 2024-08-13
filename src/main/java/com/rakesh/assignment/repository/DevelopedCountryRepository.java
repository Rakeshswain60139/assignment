package com.rakesh.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.assignment.entity.DevelopedCountryEntity;

public interface DevelopedCountryRepository extends JpaRepository<DevelopedCountryEntity, Long> {

}
