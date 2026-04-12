package by.darkimpulsepoint.task1.parser.impl;

import by.darkimpulsepoint.task1.parser.ArrayParser;
import java.util.Arrays;

public class IntegerArrayParser implements ArrayParser<Integer> {
    @Override
    public Integer[] parseLine(String line) {
        return Arrays.stream(line.trim().split("\\s*"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}