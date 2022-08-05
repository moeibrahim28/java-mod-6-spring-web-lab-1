package com.example.AccessCamp.repository;

import com.example.AccessCamp.models.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignupRepository extends JpaRepository<Signup, Integer> {
}
