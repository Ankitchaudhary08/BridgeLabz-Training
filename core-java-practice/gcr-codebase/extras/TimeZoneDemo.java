import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeZoneDemo {

    public static void main(String[] args) {

        // Formatter for readable date and time
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss z");

        // Current time in GMT
        ZonedDateTime gmtTime = ZonedDateTime.now(ZoneId.of("GMT"));
        System.out.println("Current Time in GMT : " + gmtTime.format(format));

        // Current time in IST (India standard time)
        // IST zone id is Asia/Kolkata (many people confuse it)
        ZonedDateTime istTime = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST : " + istTime.format(format));

        // Current time in PST
        // PST is mainly use in USA west coast
        ZonedDateTime pstTime = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println("Current Time in PST : " + pstTime.format(format));

        // Program finish here, very simple example
    }
}
