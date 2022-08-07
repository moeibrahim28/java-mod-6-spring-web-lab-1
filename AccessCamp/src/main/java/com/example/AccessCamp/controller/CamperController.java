package com.example.AccessCamp.controller;

import com.example.AccessCamp.dto.CamperDTO;
import com.example.AccessCamp.dto.CreateCamperDTO;
import com.example.AccessCamp.service.CamperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campers")
public class CamperController {
    @Autowired
    private CamperService camperService;

    @PostMapping // localhost:8080/camps POST
    public CamperDTO createCamper(@RequestBody CreateCamperDTO camperDTO) {
        return camperService.createCamper(camperDTO);
    }

    @GetMapping // localhost:8080/camps GET
    public List<CamperDTO> getCampers() {
        return camperService.getAllCamper();
    }

    @GetMapping("/{id}")  // localhost:8080/camps/1
    public CamperDTO getCamper(@PathVariable Long id) {
        return camperService.getCamper(id);
    }
}
