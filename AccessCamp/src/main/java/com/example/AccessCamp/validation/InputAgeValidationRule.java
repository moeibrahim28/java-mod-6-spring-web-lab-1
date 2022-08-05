package com.example.AccessCamp.validation;

@FunctionalInterface
public interface InputAgeValidationRule {
    boolean isValidAge(int input);
}