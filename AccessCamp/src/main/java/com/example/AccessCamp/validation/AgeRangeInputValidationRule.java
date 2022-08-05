package com.example.AccessCamp.validation;

import java.util.Optional;

public class AgeRangeInputValidationRule implements InputAgeValidationRule{
    @Override
    public boolean isValidAge(int input) {
        return Optional.ofNullable(input).filter(num-> num>=8 && num<=18).isPresent();
    }
}
