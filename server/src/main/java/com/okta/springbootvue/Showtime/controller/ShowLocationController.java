package com.okta.springbootvue.Showtime.controller;

import com.okta.springbootvue.Showtime.entity.ShowLocation;
import com.okta.springbootvue.Showtime.repository.ShowLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ShowLocationController {

    @Autowired
    private final ShowLocationRepository showlocationRepository;

    public ShowLocationController(ShowLocationRepository showlocationRepository) {
        this.showlocationRepository = showlocationRepository;
    }

    @GetMapping("/showlocation")
    public Collection<ShowLocation> Shows() {
        return showlocationRepository.findAll().stream().collect(Collectors.toList());
    }

 

}