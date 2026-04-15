package by.darkimpulsepoint.task1.factory.impl;

import by.darkimpulsepoint.task1.entity.SimpleArray;
import by.darkimpulsepoint.task1.entity.SimpleArrayImpl;
import by.darkimpulsepoint.task1.factory.AbstractArrayFactory;
import by.darkimpulsepoint.task1.parser.impl.IntegerArrayParser;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class NumericArrayFactory implements AbstractArrayFactory<SimpleArray<Integer>> {

    private final IntegersLineValidator validator;
    private static final Logger logger = LogManager.getLogger(NumericArrayFactory.class);

    public NumericArrayFactory(IntegersLineValidator validator) {
        this.validator = validator;
    }

    @Override
    public Optional<SimpleArray<Integer>> createArray(String line) {
        if (line == null || line.trim().isEmpty()) {
            logger.warn("Cannot create array from null or empty line");
            return Optional.empty();
        }

        if (validator.validate(line)) {
            try {
                var parser = new IntegerArrayParser();
                Integer[] parsedValues = parser.parseLine(line);

                SimpleArrayImpl<Integer> array = new SimpleArrayImpl<>(10); // начальная ёмкость

                for (Integer value : parsedValues) {
                    if (value != null) {
                        array.add(value);
                    }
                }

                logger.info("Successfully created NumericArray with {} elements from line: {}",
                        array.size(), line);

                return Optional.of(array);

            } catch (Exception e) {
                logger.error("Error while creating array from line: {}", line, e);
                return Optional.empty();
            }
        } else {
            logger.warn("Validation failed for line: {}", line);
            return Optional.empty();
        }
    }
}