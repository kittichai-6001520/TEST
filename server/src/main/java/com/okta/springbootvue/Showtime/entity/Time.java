package com.okta.springbootvue.Showtime.entity;

import lombok.*;

import javax.persistence.Id;

//mport javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Entity
@NoArgsConstructor
@Table(name="TIME")
public class Time {
    @Id
    @SequenceGenerator(name="TIME_SEQ",sequenceName="TIME_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="TIME_SEQ")
    @Column(name="TIME_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String time;

 
}