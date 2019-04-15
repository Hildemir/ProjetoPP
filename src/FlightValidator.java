import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.regex.Pattern;

public class FlightValidator {
    public static boolean isValidFlight(String flightCode) {
        return Pattern.matches("[a-zA-Z]{3}[0-9]{4}", flightCode);
    }

    public static boolean isValidDate(String date) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        try {
            return (format.parse(date).after(Calendar.getInstance().getTime()));
        } catch (ParseException e) {
            return false;
        }
    }

    public static boolean isValidTime(String time) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm")
                    .withResolverStyle(ResolverStyle.STRICT);
            LocalTime.parse(time, formatter);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidPrice(double price) {
        return price > 0;
    }
}

