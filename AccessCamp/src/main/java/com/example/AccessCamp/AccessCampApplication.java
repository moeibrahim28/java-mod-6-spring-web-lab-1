package com.example.AccessCamp;

import com.example.AccessCamp.dto.*;
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

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AccessCampApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccessCampApplication.class, args);
    }


    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }

}