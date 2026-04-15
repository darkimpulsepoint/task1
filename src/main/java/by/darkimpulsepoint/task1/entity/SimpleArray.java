package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.observer.Observable;

public interface SimpleArray<T> extends Observable<T> {
    void add(T element);

    T get(int index) throws SimpleArrayException;

    void replace(int index, T element) throws SimpleArrayException;

    int size();
}