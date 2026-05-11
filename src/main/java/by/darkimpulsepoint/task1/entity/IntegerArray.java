package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;

import java.util.Arrays;

public class IntegerArray {
    private static final int DEFAULT_CAPACITY = 10;
    private Long id;
    private int[] array;
    private int size;

    public IntegerArray() {
        this(DEFAULT_CAPACITY);
    }

    public IntegerArray(int capacity) {
        this.array = new int[capacity > 0 ? capacity : DEFAULT_CAPACITY];
        this.size = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void add(int element) {
        if (size == array.length) {
            int newCapacity = array.length * 2;
            array = Arrays.copyOf(array, newCapacity);
        }
        array[size++] = element;
    }

    public int get(int index) throws SimpleArrayException {
        if (index < 0 || index >= size) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        return array[index];
    }

    public void set(int index, int element) throws SimpleArrayException {
        if (index < 0 || index >= size) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        array[index] = element;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        IntegerArray that = (IntegerArray) obj;

        if (size != that.size) return false;

        for (int i = 0; i < size; i++) {
            if (array[i] != that.array[i]) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + size;

        for (int i = 0; i < size; i++) {
            result = 31 * result + array[i];
        }
        return result;
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
