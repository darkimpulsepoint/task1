package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumComparator<E extends Number> implements SimpleArrayComparator<SimpleArray<E>> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(SimpleArray<E> a, SimpleArray<E> b) {
        double sumA = calculateSum(a);
        double sumB = calculateSum(b);
        return Double.compare(sumA, sumB);
    }

    private double calculateSum(SimpleArray<E> array) {
        double sum = 0.0;
        for (int i = 0; i < array.size(); i++) {
            try {
                E num = array.get(i);
                if (num != null) {
                    sum += num.doubleValue();
                }
            } catch (SimpleArrayException e) {
                logger.error("Error accessing element", e);
                return 0;
            }
        }
        return sum;
    }
}