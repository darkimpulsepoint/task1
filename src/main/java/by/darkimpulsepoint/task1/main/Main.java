package by.darkimpulsepoint.task1.main;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.exception.ArrayReaderException;
import by.darkimpulsepoint.task1.factory.AbstractArrayFactory;
import by.darkimpulsepoint.task1.factory.impl.IntegerArrayFactory;
import by.darkimpulsepoint.task1.reader.ArrayReader;
import by.darkimpulsepoint.task1.reader.impl.ArrayReaderImpl;
import by.darkimpulsepoint.task1.service.impl.IntegerArrayService;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;
import java.util.Optional;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "data/numbers.txt";

    public static void main(String[] args) {
        logger.info("Application starting...");

        ArrayReader reader = new ArrayReaderImpl();
        IntegersLineValidator validator = new IntegersLineValidator();
        AbstractArrayFactory<IntegerArray> factory = new IntegerArrayFactory(validator);
        IntegerArrayService service = new IntegerArrayService();

        try {
            List<String> lines = reader.read(FILE_PATH);
            logger.info("Successfully read {} lines from file {}", lines.size(), FILE_PATH);

            int lineCounter = 1;
            for (String line : lines) {
                System.out.println("----------------------------------------");
                System.out.printf("Processing line #%d: \"%s\"\n", lineCounter++, line);

                Optional<IntegerArray> arrayOptional = factory.createArray(line);

                if (arrayOptional.isPresent()) {
                    IntegerArray array = arrayOptional.get();
                    System.out.println("Successfully created array: " + array);

                    service.findMinElement(array)
                            .ifPresent(min -> System.out.println("Min element: " + min));

                    service.findMaxElement(array)
                            .ifPresent(max -> System.out.println("Max element: " + max));

                    System.out.println("Sum of elements: " + service.findSum(array));
                    System.out.printf("Average of elements: %.2f\n", service.findAverage(array));

                    service.bubbleSort(array);
                    System.out.println("Sorted array: " + array);

                } else {
                    System.out.println("Result: Could not create array. The line is invalid or empty.");
                }
            }
            System.out.println("----------------------------------------");

        } catch (ArrayReaderException e) {
            logger.error("Failed to read the data file.", e);
            System.err.println("Error: " + e.getMessage());
        }

        logger.info("Application finished.");
    }
}