package com.okta.springbootvue.Showtime.repository;

import com.okta.springbootvue.Showtime.entity.ShowLocation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ShowLocationRepository extends JpaRepository<ShowLocation, Long> {
	ShowLocation findById(long id);
}