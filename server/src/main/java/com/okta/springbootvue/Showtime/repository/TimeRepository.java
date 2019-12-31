package com.okta.springbootvue.Showtime.repository;

import com.okta.springbootvue.Showtime.entity.Time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface TimeRepository extends JpaRepository<Time, Long> {
	Time findById(long id);
}