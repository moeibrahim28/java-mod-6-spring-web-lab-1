package com.example.AccessCamp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
public class SignupDTO {
    private List<ActivityDTO> activities = new ArrayList<>();
}
