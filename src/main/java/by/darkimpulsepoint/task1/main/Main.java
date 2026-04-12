package by.darkimpulsepoint.task1.main;

import by.darkimpulsepoint.task1.validator.impl.IntegersLineValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger();

    public static void main() {
        IntegersLineValidator integersLineValidator = new IntegersLineValidator();
        System.out.println(integersLineValidator.validate("4646- -5"));

    }
}
