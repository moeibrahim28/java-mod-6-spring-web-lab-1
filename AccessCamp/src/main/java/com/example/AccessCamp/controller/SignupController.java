package com.example.AccessCamp.controller;

import com.example.AccessCamp.dto.ActivityDTO;
import com.example.AccessCamp.dto.SignupDTO;
import com.example.AccessCamp.models.Activity;
import com.example.AccessCamp.models.Signup;
import com.example.AccessCamp.service.ActivityService;
import com.example.AccessCamp.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/signups")
public class SignupController {
    @Autowired
    private SignupService signupService;

    @PostMapping("/signups")
    public SignupDTO createSignup(@Valid @RequestBody SignupDTO signup) {

        return signupService.createSignup(signup);
    }

    @GetMapping("/signups")
    public List<SignupDTO> readSignups() {
        return signupService.getAllSignup();
    }

    @GetMapping("/signups/{signupId}")
    public SignupDTO readSignup(@PathVariable(value = "signupId") Integer id) {
        return signupService.getSignup(id);
    }


    // The @DeleteMapping is a shorthand for the @RequestMapping(value="/activities/{activityId}", method=RequestMethod.DELETE) annotation.
    // This method calls the deleteActivity method on the activityService class which removes the record with the given ID from the database.
    @DeleteMapping("/signups/{signupId}")
    public void deleteSignup(@PathVariable(value = "signupId") Integer id) {
        signupService.deleteSignup(id);
    }

}
