package com.rakesh.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.assignment.entity.LinesEntity;

public interface LineRepository extends JpaRepository<LinesEntity, Long> {

}
