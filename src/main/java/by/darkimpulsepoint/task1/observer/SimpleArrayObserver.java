package by.darkimpulsepoint.task1.observer;

import by.darkimpulsepoint.task1.entity.SimpleArray;

public interface SimpleArrayObserver<T> {
    void update(SimpleArray<T> array);
}