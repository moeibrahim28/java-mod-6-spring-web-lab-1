package com.example.AccessCamp.repository;

import com.example.AccessCamp.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
