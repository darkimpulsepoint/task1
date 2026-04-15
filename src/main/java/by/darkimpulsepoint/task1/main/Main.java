package by.darkimpulsepoint.task1.main;

import by.darkimpulsepoint.task1.comparator.impl.FirstElementComparator;
import by.darkimpulsepoint.task1.comparator.impl.SumComparator;
import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.exception.SimpleArrayException;
import by.darkimpulsepoint.task1.factory.impl.NumericArrayFactory;
import by.darkimpulsepoint.task1.observer.impl.SimpleArrayObserverImpl;
import by.darkimpulsepoint.task1.pool.Warehouse;
import by.darkimpulsepoint.task1.service.impl.IntegerArrayService;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("=== SimpleArray Implementation Demo Started ===");

        logger.info("1. Creating arrays from strings using NumericArrayFactory");

        IntegersLineValidator validator = new IntegersLineValidator();
        NumericArrayFactory factory = new NumericArrayFactory(validator);

        String[] inputLines = {
                "10 20 30 40",
                "5 15 -25 8",
                "100",
                "1 2 3 4 5 6 7",
                "   "
        };

        List<SimpleArray<Integer>> arrays = new ArrayList<>();

        for (String line : inputLines) {
            Optional<SimpleArray<Integer>> optionalArray = factory.createArray(line);
            if (optionalArray.isPresent()) {
                arrays.add(optionalArray.get());
                logger.info("Successfully created array: {}", optionalArray.get());
            } else {
                logger.warn("Failed to create array from line: '{}'", line);
            }
        }

        logger.info("Total successfully created arrays: {}", arrays.size());

        if (!arrays.isEmpty()) {
            SimpleArray<Integer> array = arrays.get(0);
            logger.info("2. Performing basic operations on array: {}", array);

            logger.info("Array size: {}", array.size());

            try {
                logger.info("Element at index 2: {}", array.get(2));

                array.replace(1, 999);
                logger.info("After replacing index 1 with 999: {}", array);

            } catch (SimpleArrayException e) {
                logger.error("Error during array operation", e);
            }
        }

        logger.info("3. Demonstrating comparators");

        FirstElementComparator<Integer> firstElementComparator = new FirstElementComparator<>();
        SumComparator<Integer> sumComparator = new SumComparator<>();

        arrays.sort(firstElementComparator);
        logger.info("Arrays sorted by First Element:");
        arrays.forEach(arr -> logger.info("{}", arr));

        arrays.sort(sumComparator);
        logger.info("Arrays sorted by Sum:");
        arrays.forEach(arr -> logger.info("{}", arr));

        logger.info("4. Demonstrating Observer Pattern and Warehouse");

        Warehouse<Integer> warehouse = Warehouse.getInstance();
        IntegerArrayService service = new IntegerArrayService();
        SimpleArrayObserverImpl<Integer> observer = new SimpleArrayObserverImpl<>(warehouse, service);

        if (!arrays.isEmpty()) {
            SimpleArrayImpl<Integer> observableArray = (SimpleArrayImpl<Integer>) arrays.get(0);

            observableArray.addObserver(observer);

            logger.info("Initial array: {}", observableArray);
            warehouse.getParameters(observableArray).ifPresent(params ->
                    logger.info("Initial parameters in warehouse: {}", params)
            );

            try {
                observableArray.replace(0, 7777);
                logger.info("After modifying array (replaced first element with 7777): {}", observableArray);

                warehouse.getParameters(observableArray).ifPresent(params ->
                        logger.info("Updated parameters in warehouse: {}", params)
                );

            } catch (SimpleArrayException e) {
                logger.error("Error while modifying observable array", e);
            }
        }

        logger.info("=== SimpleArray Implementation Demo Finished ===");
    }
}