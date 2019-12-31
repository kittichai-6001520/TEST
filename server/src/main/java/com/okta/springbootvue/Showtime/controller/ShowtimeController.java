package com.okta.springbootvue.Showtime.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;
import com.okta.springbootvue.Showtime.entity.Show;
import com.okta.springbootvue.Showtime.entity.Showtime;
import com.okta.springbootvue.Showtime.entity.Time;
import com.okta.springbootvue.Showtime.entity.ShowLocation;
import com.okta.springbootvue.Showtime.repository.ShowRepository;
import com.okta.springbootvue.Showtime.repository.TimeRepository;
import com.okta.springbootvue.Showtime.repository.ShowtimeRepository;
import com.okta.springbootvue.Showtime.repository.ShowLocationRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class ShowtimeController {
    @Autowired
    private final ShowtimeRepository showtimeRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowLocationRepository showLocationRepository;
    @Autowired
    private TimeRepository timeRepository;
    

    ShowtimeController(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }
    @GetMapping("/showtimeCheck/{show_id}/{time_id}/{location_id}/{showdatetime}")
    public Collection<Showtime> getSubjectsByStudent(@PathVariable("show_id") Long show_id,
    @PathVariable("time_id") Long time_id,
    @PathVariable("location_id") Long location_id,
    @PathVariable("showdatetime") String showdatetime) 
    throws ParseException {
    DateFormat d = new SimpleDateFormat("yyyy-MM-dd");
    Date showdate = d.parse(showdatetime);
        return showtimeRepository.findShowtimeByShowtime(show_id,time_id,location_id,showdate);
    }

    @GetMapping("/showtime")
    public Collection<Showtime> Showtimes() {
        return showtimeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/showtime/{show_id}/{time_id}/{location_id}/{showdate}")
    public Showtime newShowtime(Showtime newShowtime,
    @PathVariable long show_id,
    @PathVariable long time_id,
    @PathVariable long location_id,
    @PathVariable String showdate
    ) throws ParseException {
    
    Show show = showRepository.findById(show_id);
    Time time = timeRepository.findById(time_id);
    ShowLocation location = showLocationRepository.findById(location_id);
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    Date datetime = df.parse(showdate);

    newShowtime.setShow(show);
    newShowtime.setTime(time);
    newShowtime.setLocation(location);
    newShowtime.setShowDate(datetime);
    //newShowtime.setTimeDate(showdate);
    

    return showtimeRepository.save(newShowtime); //บันทึก Objcet ชื่อ VideoRental
    
    }
}