package by.darkimpulsepoint.task1.factory;

import by.darkimpulsepoint.task1.entity.SimpleArray;

import java.util.Optional;

public interface AbstractArrayFactory<R extends SimpleArray<?>> {
    Optional<R> createArray(String string);
}