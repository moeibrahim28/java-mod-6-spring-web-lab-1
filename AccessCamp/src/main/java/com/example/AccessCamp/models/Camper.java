package com.example.AccessCamp.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Camper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @NotBlank
    private String name;
    @Min(value = 8)
    @Max(value = 18)
    private int age;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "camper", fetch = FetchType.EAGER)
    private List<Signup> signupList = new ArrayList<>();


}
