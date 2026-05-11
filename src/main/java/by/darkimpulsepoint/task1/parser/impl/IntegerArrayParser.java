package by.darkimpulsepoint.task1.parser.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import java.util.Arrays;

public class IntegerArrayParser {
    private static final String WHITESPACE_REGEX = "\\s+";

    public IntegerArray parseLine(String line) {
        int[] values = Arrays.stream(line.strip().split(WHITESPACE_REGEX))
                .mapToInt(Integer::parseInt)
                .toArray();

        IntegerArray array = new IntegerArray(values.length);
        for (int value : values) {
            array.add(value);
        }
        return array;
    }
}