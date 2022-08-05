package com.example.AccessCamp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Signup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int time;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @ManyToOne
    private Camper camper;

    @ManyToOne
    private Activity activity;

}
