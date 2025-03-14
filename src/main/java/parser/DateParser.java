package parser;

import exceptions.HandleException;

import static exceptions.ExceptionTypes.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static constants.Constants.INPUT_DATE_FORMATS;

public class DateParser {
    /**
     * Parses a date-time string into a {@code LocalDateTime} object, supporting multiple formats.
     *
     * @param dateTimeString The user input string representing date and time.
     * @return A {@code LocalDateTime} object if parsing succeeds.
     * @throws HandleException If none of the supported formats match the input.
     */
    public static LocalDateTime parseDateTime(String dateTimeString) throws HandleException {
        for (DateTimeFormatter formatter : INPUT_DATE_FORMATS) {
            try {
                return LocalDateTime.parse(dateTimeString, formatter);
            } catch (DateTimeParseException ignored) {
                // Try the next format
            }
        }
        // If no format worked, throw a HandleException
        throw new HandleException(INCORRECT_DATE_AND_TIME_FORMAT);
    }
}
