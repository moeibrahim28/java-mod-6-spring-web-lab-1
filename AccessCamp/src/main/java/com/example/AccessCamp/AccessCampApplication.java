package com.example.AccessCamp;

import com.example.AccessCamp.dto.*;
import com.example.AccessCamp.models.Activity;
import com.example.AccessCamp.models.Camper;
import com.example.AccessCamp.models.Signup;
import com.example.AccessCamp.repository.ActivityRepository;
import com.example.AccessCamp.repository.CamperRepository;
import com.example.AccessCamp.repository.SignupRepository;
import com.example.AccessCamp.service.ActivityService;
import com.example.AccessCamp.service.CamperService;
import com.example.AccessCamp.service.SignupService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AccessCampApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessCampApplication.class, args);
    }

    @Bean
    @Transactional
    CommandLineRunner runner(ActivityRepository activityRepository, CamperRepository camperRepository,
                             SignupRepository signupRepository) {
        return (args) -> {
            Activity archery = activityRepository
                    .save(new Activity(1, "Archery", 2, LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
            Activity swimming = activityRepository
                    .save(new Activity(2, "Swimming", 3, LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
            Camper caitlin = camperRepository
                    .save(new Camper(1, "Caitlin", 8, LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
            Camper lizzie = camperRepository
                    .save(new Camper(2, "Lizzie", 9, LocalDateTime.now(), LocalDateTime.now(), new ArrayList<>()));
            Signup archerySignup = signupRepository
                    .save(new Signup(1, 9, LocalDateTime.now(), LocalDateTime.now(), caitlin, archery));
            Signup swimmingSignup = signupRepository
                    .save(new Signup(2, 10, LocalDateTime.now(), LocalDateTime.now(), lizzie, swimming));
            archery.setActivities(List.of(archerySignup, swimmingSignup));
            caitlin.setActivities(List.of(archerySignup, swimmingSignup));
        };
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}