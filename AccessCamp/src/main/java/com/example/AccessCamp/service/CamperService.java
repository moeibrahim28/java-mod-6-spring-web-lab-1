package com.example.AccessCamp.service;

import com.example.AccessCamp.dto.CamperDTO;
import com.example.AccessCamp.dto.CreateCamperDTO;
import com.example.AccessCamp.models.Camper;
import com.example.AccessCamp.repository.CamperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CamperService {
    @Autowired
    private CamperRepository camperRepository; // field injection

    @Autowired
    private SignupService signupService;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ModelMapper mapper;

    public CamperDTO createCamper(CreateCamperDTO createDTO) {
        // Convert the HospitalCreateDTO to a Hospital entity
        Camper camper = mapper.map(createDTO, Camper.class);
        camper = camperRepository.save(camper);
        return mapper.map(camper, CamperDTO.class);
    }

    public CamperDTO getCamper(long id) {
        Camper camper =
                camperRepository.findById((int) id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.map(camper, CamperDTO.class);
    }

    public void deleteCamper(Integer id) {
        camperRepository.deleteById(id);
    }

    public List<CamperDTO> getAllCamper() {
        return camperRepository.findAll().stream().map(camper -> mapper.map(camper, CamperDTO.class)).toList();
    }
}
