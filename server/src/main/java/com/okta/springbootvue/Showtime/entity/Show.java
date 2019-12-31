package com.okta.springbootvue.Showtime.entity;

import lombok.*;

import javax.persistence.Id;

//import javax.persistence.OneToMany;
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
@Table(name="SHOW")
public class Show {
    @Id
    @SequenceGenerator(name="SHOW_SEQ",sequenceName="SHOW_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SHOW_SEQ")
    @Column(name="SHOW_ID",unique = true, nullable = true)
    private @NonNull Long id;

    private @NonNull String title;

    /*@OneToMany(fetch = FetchType.EAGER)
    
    private Collection<Showtime> showtime;*/
}