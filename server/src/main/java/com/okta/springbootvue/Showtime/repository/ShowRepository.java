package com.okta.springbootvue.Showtime.repository;

import com.okta.springbootvue.Showtime.entity.Show;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface ShowRepository extends JpaRepository<Show, Long> {
	Show findById(long id);
}