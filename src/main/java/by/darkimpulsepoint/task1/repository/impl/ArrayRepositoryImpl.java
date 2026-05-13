package by.darkimpulsepoint.task1.repository.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.repository.ArrayRepository;
import by.darkimpulsepoint.task1.specification.ArraySpecification;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayRepositoryImpl implements ArrayRepository {

    private final List<IntegerArray> storage = new ArrayList<>();

    @Override
    public void add(IntegerArray array) {
        storage.add(array);
    }

    @Override
    public void remove(IntegerArray array) {
        storage.remove(array);
    }

    @Override
    public List<IntegerArray> sort(Comparator<IntegerArray> comparator) {
        List<IntegerArray> sorted = new ArrayList<>(storage);
        sorted.sort(comparator);
        return sorted;
    }

    @Override
    public List<IntegerArray> query(ArraySpecification specification) {
        return storage.stream()
                .filter(specification::isSatisfiedBy)
                .collect(Collectors.toList());
    }
}