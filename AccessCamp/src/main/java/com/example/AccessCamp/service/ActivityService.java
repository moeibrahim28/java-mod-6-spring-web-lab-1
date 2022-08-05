package com.example.AccessCamp.service;

import com.example.AccessCamp.dto.ActivityDTO;
import com.example.AccessCamp.models.Activity;
import com.example.AccessCamp.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository; // field injection

    @Autowired
    private ModelMapper mapper;

    public ActivityDTO createActivity(ActivityDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Activity activity = mapper.map(createDTO, Activity.class);
        activity = activityRepository.save(activity);
        return mapper.map(activity, ActivityDTO.class);
    }

    public ActivityDTO getActivity(long id) {
        Activity activity =
                activityRepository.findById((int) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(activity, ActivityDTO.class);
    }

    public Activity updateActivity(Integer id, Activity activityData) {
        if (!activityRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Activity activity = activityRepository.findById(id).get();
        activity.setName(activityData.getName());
        activity.setDifficulty(activityData.getDifficulty());
        activity.setSignupList(activityData.getSignupList());
        return activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        activityRepository.deleteById(id);
    }

    public List<ActivityDTO> getAllActivity() {
        return activityRepository.findAll().stream().map(camp -> mapper.map(camp, ActivityDTO.class)).toList();
    }
}
