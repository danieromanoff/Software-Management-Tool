package softwaremanagementtool.agile;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//std date class to add date in the user story view. ( can be removed if not required )
public class DateUtil {

    // date format can be changed if required
    private static final String DATE_PATTERN = "dd.MM.yyyy";

    private static final DateTimeFormatter DATE_FORMATTER = 
            DateTimeFormatter.ofPattern(DATE_PATTERN);

    //  converting date to string 
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    // converting date to string
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    // string/ date validation 
    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }
}
