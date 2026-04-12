package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;

public class IntegerArray implements SimpleArray<Integer> {
    private Integer[] array;
    private int size;

    public IntegerArray(int capacity) {
        array = new Integer[capacity];
        size = capacity;
    }

    @Override
    public void replace(int index, Integer el) {
        if (index < 0 || index >= size) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        array[index] = el;
    }

    @Override
    public void add(Integer element) {
        var newArray = new Integer[size++ + 1];

        for (int i = 0; i < size - 1; i++) {
            newArray[i] = array[i];
        }

        newArray[size - 1] = element;
        array = newArray;
    }

    @Override
    public Integer get(int index) throws SimpleArrayException {
        if (index < 0 || index >= size) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        return array[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        IntegerArray that = (IntegerArray) obj;

        if (this.size != that.size) return false;

        for (int i = 0; i < size; i++) {
            Integer thisEl = this.array[i];
            Integer thatEl = that.array[i];

            if (thisEl == null) {
                if (thatEl != null) return false;
            } else if (!thisEl.equals(thatEl)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + size;

        for (int i = 0; i < size; i++) {
            Integer el = array[i];
            result = 31 * result + (el == null ? 0 : el.hashCode());
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