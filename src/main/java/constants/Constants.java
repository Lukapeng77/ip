package constants;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String LINE_SEPARATOR = "____________________________________________________________\n";
    public static final String INDENT = "%s";

    public static final DateTimeFormatter INPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    public static final DateTimeFormatter SEARCH_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern(" MMM dd yyyy, hh:mm a ");
}