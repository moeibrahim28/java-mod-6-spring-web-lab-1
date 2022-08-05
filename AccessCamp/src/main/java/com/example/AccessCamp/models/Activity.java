package com.example.AccessCamp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int difficulty;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "activity", fetch = FetchType.EAGER)
    private List<Signup> signupList = new ArrayList<>();

}
