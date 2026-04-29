package by.darkimpulsepoint.task1.parser.impl;

import by.darkimpulsepoint.task1.parser.ArrayParser;
import java.util.Arrays;

public class IntegerArrayParser implements ArrayParser<Integer> {
    private static final String WHITESPACE_REGEX = "\\s+";

    @Override
    public Integer[] parseLine(String line) {
        return Arrays.stream(line.strip().split(WHITESPACE_REGEX))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}