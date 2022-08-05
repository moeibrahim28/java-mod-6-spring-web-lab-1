package com.example.AccessCamp.validation;

public interface UserStringInputService extends AutoCloseable {
    String getUserInput(String prompt, InputValidationRule... rules);
    <T> T getUserChoice(String prompt, T... options);
}
