package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstElementComparator implements SimpleArrayComparator {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(IntegerArray a, IntegerArray b) {
        try {
            if (a.size() == 0 && b.size() == 0) return 0;
            if (a.size() == 0) return -1;
            if (b.size() == 0) return 1;

            int firstA = a.get(0);
            int firstB = b.get(0);

            return Integer.compare(firstA, firstB);
        } catch (SimpleArrayException e) {
            logger.error("Error accessing element", e);
            return 0;
        }
    }
}