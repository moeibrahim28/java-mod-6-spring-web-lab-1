package com.example.AccessCamp.validation;

@FunctionalInterface
public interface InputValidationRule {
    boolean isValidName(String input);
}
