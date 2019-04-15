import java.util.regex.Pattern;

public class TicketValidator {
    public static boolean isValidChair(String chair) {
        return Pattern.matches("[1-6][A-F]", chair);
    }
}
