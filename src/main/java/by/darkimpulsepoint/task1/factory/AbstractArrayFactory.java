package by.darkimpulsepoint.task1.factory;

import by.darkimpulsepoint.task1.entity.IntegerArray;

import java.util.Optional;

public interface AbstractArrayFactory {
    Optional<IntegerArray> createArray(String string);
}