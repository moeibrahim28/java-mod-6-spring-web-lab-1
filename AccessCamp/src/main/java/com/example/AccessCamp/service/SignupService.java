package com.example.AccessCamp.service;

import com.example.AccessCamp.dto.SignupDTO;
import com.example.AccessCamp.models.Signup;
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
    private ModelMapper mapper;

    public SignupDTO createSignup(SignupDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Signup signup = mapper.map(createDTO, Signup.class);
        signup = signupRepository.save(signup);
        return mapper.map(signup, SignupDTO.class);
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

