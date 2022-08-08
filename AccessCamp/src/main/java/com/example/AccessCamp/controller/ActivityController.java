package com.example.AccessCamp.controller;


import com.example.AccessCamp.dto.ActivityDTO;
import com.example.AccessCamp.dto.CamperDTO;
import com.example.AccessCamp.models.Activity;
import com.example.AccessCamp.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    // ActivityService Injection
    // The ActivityService object is injected automatically by Spring into the controller, so we can use it in the class.
    @Autowired
    private ActivityService activityService;

    // This method is creating the /api/activities endpoint for the POST HTTP method and persisting the data sent from the client.
    // The @PostMapping annotation is a shorthand for the @RequestMapping(value="/activities", method=RequestMethod.POST) annotation.
    // Both of these annotations define the endpoint path as /api/activities
//    @PostMapping("/activities")
//    public ResponseEntity<Activity> createActivity(@Valid @RequestBody Activity activity) {
//        Activity newActivity = activityService.createActivity(activity);
//        // Notice that we are returning a ResponseEntity instead of an Activity object like earlier.
//        // The ResponseEntity allows us to modify response information (status code, headers) before sending them back to the client.
//        return ResponseEntity.ok(newActivity);
//    }

    @PostMapping
    public ActivityDTO createActivity(@Valid @RequestBody ActivityDTO activity) {
        return activityService.createActivity(activity);
    }

    // The @GetMapping is a shorthand for the @RequestMapping(value="/activities", method=RequestMethod.GET) annotation.
    // Both of these annotations define the endpoint path as /api/activities.
    // The readActivities method calls the ActivityService to retrieve all the activity records from the database and returns a JSON
//    @GetMapping("/activities")
//    public List<Activity> readActivities() {
//        return activityService.getActivities();
//    }

    @GetMapping("/activities")
    public List<ActivityDTO> readActivities() {
        return activityService.getAllActivity();
    }

    // The {activityId} in the @GetMapping value is a dynamic value which takes on the value of the client's request path parameter.
    // For example, the following URL would assign the value of 1 to activityId and id:
    // http://localhost:8080/api/activities/1
    // The @PathVariable annotation maps the dynamic path value to the method parameter id.
//    @GetMapping("/activities/{activityId}")
//    public Activity readActivity(@PathVariable(value = "activityId") Integer id) {
//        return activityService.getActivity(id);
//    }
    @GetMapping("/activities/{activityId}")
    public ActivityDTO readActivity(@PathVariable(value = "activityId") Integer id) {
        return activityService.getActivity(id);
    }

    // The @PutMapping is a shorthand for the @RequestMapping(value="/activities/{activityId}", method=RequestMethod.PUT).
    // This method is using @PathVariable to get the ID of the record that needs to be updated and @RequestBody to get the data sent by the client.
    @PutMapping("/activities/{activityId}")
    public Activity updateActivity(@PathVariable(value = "activityId") Integer id, @RequestBody Activity activityData) {
        return activityService.updateActivity(id, activityData);
    }

    // The @DeleteMapping is a shorthand for the @RequestMapping(value="/activities/{activityId}", method=RequestMethod.DELETE) annotation.
    // This method calls the deleteActivity method on the activityService class which removes the record with the given ID from the database.
    @DeleteMapping("/activities/{activityId}")
    public void deleteActivity(@PathVariable(value = "activityId") Integer id) {
        activityService.deleteActivity(id);
    }

    @GetMapping // localhost:8080/camps GET
    public List<ActivityDTO> getActivities() {
        return activityService.getAllActivity();
    }

}
