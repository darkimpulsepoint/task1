package by.darkimpulsepoint.task1.repository.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.repository.ArrayRepository;
import by.darkimpulsepoint.task1.specification.ArraySpecification;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRepositoryImpl<T extends SimpleArray<?>> implements ArrayRepository<T> {

    private final List<T> storage = new ArrayList<>();

    @Override
    public void add(T simpleArray) {
        if (simpleArray == null) {
            throw new IllegalArgumentException("Cannot add null SimpleArray");
        }
        storage.add(simpleArray);
    }

    @Override
    public void remove(T simpleArray) {
        if (simpleArray == null) {
            return;
        }
        storage.remove(simpleArray);
    }

    @Override
    public List<T> sort(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }
        List<T> sorted = new ArrayList<>(storage);
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public List<T> query(ArraySpecification<T> specification) {
        if (specification == null) {
            return new ArrayList<>(storage);
        }
        return storage.stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }

    @Override
    public List<T> all() {
        return new ArrayList<>(storage);
    }
}