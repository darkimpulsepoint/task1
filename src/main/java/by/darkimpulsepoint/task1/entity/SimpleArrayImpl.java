package by.darkimpulsepoint.task1.entity;

import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.observer.SimpleArrayObserver;

import java.util.ArrayList;
import java.util.List;

public class SimpleArrayImpl<T> implements SimpleArray<T> {
    private Long id;
    private T[] array;
    private int size;
    private List<SimpleArrayObserver<T>> observers;

    public SimpleArrayImpl(int capacity) {
        this.array = (T[]) new Object[capacity];
        observers = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void replace(int index, T el) throws SimpleArrayException {
        if (index < 0 || index >= size) {
            throw new SimpleArrayException("Index out of range: " + index);
        }
        array[index] = el;
        notifyObservers();
    }

    @Override
    public void add(T element) {
        T[] newArray = (T[]) new Object[++size];

        if (size - 1 >= 0) System.arraycopy(array, 0, newArray, 0, size - 1);

        newArray[size - 1] = element;
        array = newArray;
        notifyObservers();
    }

    @Override
    public T get(int index) throws SimpleArrayException {
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

        SimpleArrayImpl<T> that = (SimpleArrayImpl<T>) obj;

        if (this.size != that.size) return false;

        for (int i = 0; i < size; i++) {
            T thisEl = this.array[i];
            T thatEl = that.array[i];

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
            T el = array[i];
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

    @Override
    public void addObserver(SimpleArrayObserver<T> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(SimpleArrayObserver<T> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(this));
    }
}