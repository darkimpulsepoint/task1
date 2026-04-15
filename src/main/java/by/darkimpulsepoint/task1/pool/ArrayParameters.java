package by.darkimpulsepoint.task1.pool;

public class ArrayParameters<T> {
    private final T min;
    private final T max;
    private final T sum;

    public ArrayParameters(T min, T max, T sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }

    public T getMin() {
        return min;
    }

    public T getMax() {
        return max;
    }

    public T getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "ArrayParameters{min=" + min + ", max=" + max + ", sum=" + sum + '}';
    }
}