package main.java.by.bsuir.WT.lab4.service.validator.impl;

import main.java.by.bsuir.WT.lab4.service.validator.AbstractValidator;

public class IdValidatorImpl extends AbstractValidator {
    private static final String ID_REGEX = "(?<![-.])\\b[0-9]+\\b(?!\\.[0-9])";

    @Override
    protected String getRegex() {
        return ID_REGEX;
    }
}
