package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumComparator implements SimpleArrayComparator {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(IntegerArray a, IntegerArray b) {
        int sumA = calculateSum(a);
        int sumB = calculateSum(b);
        return Integer.compare(sumA, sumB);
    }

    private int calculateSum(IntegerArray array) {
        int sum = 0;
        for (int i = 0; i < array.size(); i++) {
            try {
                sum += array.get(i);
            } catch (SimpleArrayException e) {
                logger.error("Error accessing element", e);
                return 0;
            }
        }
        return sum;
    }
}