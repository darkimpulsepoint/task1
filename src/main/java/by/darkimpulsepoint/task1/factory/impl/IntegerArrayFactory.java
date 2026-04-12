package by.darkimpulsepoint.task1.factory.impl;

import by.darkimpulsepoint.task1.entity.IntegerArray;
import by.darkimpulsepoint.task1.factory.AbstractArrayFactory;
import by.darkimpulsepoint.task1.parser.impl.IntegerArrayParser;
import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;


public class IntegerArrayFactory implements AbstractArrayFactory<IntegerArray> {
    private final IntegersLineValidator validator;
    private static final Logger logger = LogManager.getLogger();

    public IntegerArrayFactory(IntegersLineValidator validator) {
        this.validator = validator;
    }

    @Override
    public Optional<IntegerArray> createArray(String line) {
        if (validator.validate(line)) {
            IntegerArrayParser parser = new IntegerArrayParser();
            Integer[] array = parser.parseLine(line);

            IntegerArray integerArray = new IntegerArray(0);

            for (var element : array) {
                integerArray.add(element);
            }

            logger.info("Created IntegerArray from line: {}", line);
            return Optional.of(integerArray);

        } else {
            logger.warn("IntegerArray was not created from line: {}", line);
            return Optional.empty();
        }
    }
}