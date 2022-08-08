package com.example.AccessCamp.service;

import com.example.AccessCamp.dto.ActivityDTO;
import com.example.AccessCamp.dto.CreateSignupDTO;
import com.example.AccessCamp.dto.SignupDTO;
import com.example.AccessCamp.models.Signup;
import com.example.AccessCamp.repository.ActivityRepository;
import com.example.AccessCamp.repository.SignupRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SignupService {
    @Autowired
    private SignupRepository signupRepository; // field injection

    @Autowired
    private ActivityService activityService;


    @Autowired
    private ModelMapper mapper;

    public SignupDTO createSignup(CreateSignupDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Signup signup = mapper.map(createDTO, Signup.class);
ActivityDTO activityDTO = new ActivityDTO();
        List<ActivityDTO> activityDTOList = activityService.getAllActivity();
        activityDTO.setId(createDTO.getActivity_id());
        if(activityDTOList.get(activityDTO.getId()-1)!=null){
            signup = signupRepository.save(signup);
            SignupDTO signupDTO = mapper.map(signup, SignupDTO.class);

            activityDTO.setDifficulty(activityDTOList.get(activityDTO.getId()-1).getDifficulty());
            activityDTO.setName(activityDTOList.get(activityDTO.getId()-1).getName());
            signupDTO.getActivities().add(activityDTO);

            return signupDTO;
        }
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }

    public SignupDTO getSignup(long id) {
        Signup signup =
                signupRepository.findById((int) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(signup, SignupDTO.class);
    }

    public void deleteSignup(Integer id) {
        signupRepository.deleteById(id);
    }

    public List<SignupDTO> getAllSignup() {
        return signupRepository.findAll().stream().map(camp -> mapper.map(camp, SignupDTO.class)).toList();
    }
}

