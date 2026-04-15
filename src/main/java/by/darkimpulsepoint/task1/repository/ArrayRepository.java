package by.darkimpulsepoint.task1.repository;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;

public interface ArrayRepository<T extends SimpleArray<?>> {
    void add(T array);
    void remove(T array);
    List<T> sort(Comparator<T> comparator);
    List<T> query(ArraySpecification<T> specification);
    List<T> all();
}