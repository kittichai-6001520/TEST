package com.okta.springbootvue.Showtime.controller;

import com.okta.springbootvue.Showtime.entity.Time;
import com.okta.springbootvue.Showtime.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class TimeController {

    @Autowired
    private final TimeRepository timeRepository;

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    @GetMapping("/time")
    public Collection<Time> Times() {
        return timeRepository.findAll().stream().collect(Collectors.toList());
    }

 

}