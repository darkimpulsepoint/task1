package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.observer.IntegerArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegerArray {
    private static final int DEFAULT_CAPACITY = 10;
    private Long id;
    private int[] array;
    private List<IntegerArrayObserver> observers = new ArrayList<>();

    public IntegerArray() {
        this.array = new int[DEFAULT_CAPACITY];
    }

    public IntegerArray(int capacity) {
        this.array = new int[capacity];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addObserver(IntegerArrayObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(IntegerArrayObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IntegerArrayObserver observer : observers) {
            observer.update(this);
        }
    }

    public void add(int element) {
        int newLength = array.length + 1;
        array = Arrays.copyOf(array, newLength);
        array[array.length - 1] = element;
        notifyObservers();
    }

    public int[] getElements() {
        return Arrays.copyOf(array, array.length);
    }

    public void set(int index, int element) throws SimpleArrayException {
        if (index < 0 || index >= array.length) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        array[index] = element;
        notifyObservers();
    }

    public int size() {
        return array.length;
    }

    public int[] toArray() {
        return Arrays.copyOf(array, array.length);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        IntegerArray that = (IntegerArray) obj;

        if (array.length != that.array.length) return false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != that.array[i]) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + array.length;

        for (int i = 0; i < array.length; i++) {
            result = 31 * result + array[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (array.length == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
