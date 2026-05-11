package by.darkimpulsepoint.task1.pool;

public class ArrayParameters {
    private final Integer min;
    private final Integer max;
    private final Integer sum;

    public ArrayParameters(Integer min, Integer max, Integer sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }

    public Integer getMin() {
        return min;
    }

    public Integer getMax() {
        return max;
    }

    public Integer getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "ArrayParameters{min=" + min + ", max=" + max + ", sum=" + sum + '}';
    }
}