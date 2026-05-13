package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.IntegerArray;

public class FirstElementComparator implements SimpleArrayComparator {

    @Override
    public int compare(IntegerArray a, IntegerArray b) {
            int[] elementsA = a.getElements();
            int[] elementsB = b.getElements();

            return Integer.compare(elementsA[0], elementsB[0]);
    }
}