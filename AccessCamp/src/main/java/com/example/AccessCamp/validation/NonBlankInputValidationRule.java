package com.example.AccessCamp.validation;

import java.util.Optional;
import java.util.function.Predicate;

public class NonBlankInputValidationRule implements InputValidationRule {
    @Override
    public boolean isValidName(String input) {
        return Optional.ofNullable(input).filter(Predicate.not(String::isBlank)).isPresent();
    }



}