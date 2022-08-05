package com.example.AccessCamp.repository;

import com.example.AccessCamp.models.Camper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamperRepository extends JpaRepository<Camper, Integer> {

}
