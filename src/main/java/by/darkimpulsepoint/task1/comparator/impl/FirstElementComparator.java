package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FirstElementComparator<E extends Comparable<E>> implements SimpleArrayComparator<SimpleArray<E>> {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public int compare(SimpleArray<E> a, SimpleArray<E> b) {
        try {
            E firstA = a.size() > 0 ? a.get(0) : null;
            E firstB = b.size() > 0 ? b.get(0) : null;

            if (firstA == null && firstB == null) return 0;
            if (firstA == null) return -1;
            if (firstB == null) return 1;

            return firstA.compareTo(firstB);
        } catch (SimpleArrayException e) {
            logger.error("Error accessing element");
            return 0;
        }
    }
}