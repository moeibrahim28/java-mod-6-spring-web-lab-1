package com.example.AccessCamp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
public class CamperDTO {
    private int id;
    private String name;
    private int age;
    private SignupDTO activities;
}
