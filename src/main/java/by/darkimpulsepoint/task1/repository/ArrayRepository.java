package by.darkimpulsepoint.task1.repository;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository {
    void add(IntegerArray array);
    void remove(IntegerArray array);
    List<IntegerArray> sort(Comparator<IntegerArray> comparator);
    List<IntegerArray> query(ArraySpecification specification);
}