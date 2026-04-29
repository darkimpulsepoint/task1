package by.darkimpulsepoint.task1.validator.impl;

import by.darkimpulsepoint.task1.validator.LineValidator;
import java.util.regex.Pattern;

public class IntegersLineValidator implements LineValidator {
    private static final Pattern INTEGER_LINE_PATTERN = Pattern.compile("(\\s*-?\\d+)+");

    @Override
    public boolean validate(String line) {
        return INTEGER_LINE_PATTERN
                .matcher(line)
                .matches();
    }
}