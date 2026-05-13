package by.darkimpulsepoint.task1.comparator.impl;

import by.darkimpulsepoint.task1.comparator.SimpleArrayComparator;
import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.pool.ArrayParameters;
import by.darkimpulsepoint.task1.pool.Warehouse;
import java.util.Optional;

public class SumComparator implements SimpleArrayComparator {

    @Override
    public int compare(IntegerArray a, IntegerArray b) {
        Warehouse warehouse = Warehouse.getInstance();

        Optional<ArrayParameters> paramsA = warehouse.getParameters(a);
        Optional<ArrayParameters> paramsB = warehouse.getParameters(b);

        int sumA = paramsA.get().getSum();
        int sumB = paramsB.get().getSum();

        return Integer.compare(sumA, sumB);
    }
}