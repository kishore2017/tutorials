package com.sample.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Issues with the Existing Date/Time APIs(Java 7 and Below) Thread Safety – The
 * Date and Calendar classes are not thread safe, leaving developers to deal
 * with the headache of hard to debug concurrency issues and to write additional
 * code to handle thread safety. On the contrary the new Date and Time APIs
 * introduced in Java 8 are immutable and thread safe, thus taking that
 * concurrency headache away from developers.
 * 
 * APIs Design and Ease of Understanding – The Date and Calendar APIs are poorly
 * designed with inadequate methods to perform day-to-day operations. The new
 * Date/Time APIs is ISO centric and follows consistent domain models for date,
 * time, duration and periods. There are a wide variety of utility methods that
 * support the commonest operations.
 * 
 * ZonedDate and Time – Developers had to write additional logic to handle
 * timezone logic with the old APIs, whereas with the new APIs, handling of
 * timezone can be done with Local and ZonedDate/Time APIs.
 * 
 * @author kishore
 *
 */
public class DateUtilPlayground {

    public static void main(String[] args) {
        runDateUtils();
    }

    private static void runDateUtils() {
        System.out.println("################ Date Utils Example Started ###############");

        // By default LocalDate uses ISO Format "yyyy-mm-dd"
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2019, 8, 13));
        System.out.println(LocalDate.parse("2019-08-13"));
        System.out.println();

        // the current time using the system clock and default time-zone, not null
        System.out.println(LocalTime.now());
        System.out.println(LocalTime.of(23, 8, 13));
        System.out.println(LocalTime.parse("10:15:30"));
        System.out.println();

        // LocalDateTime default format 2007-12-03T10:15:30
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.of(2019, 8, 13, 12, 12));
        System.out.println(LocalDateTime.parse("2019-08-13T12:12:00"));
        System.out.println();

        // DateFormatter
        String date = "2017-31-08 12:30:54";
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(date, format);
        System.out.println(dateTime);
        System.out.println();

        // ZonedDate
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Indiana/Indianapolis"));
        LocalDate localDate = zonedDateTime.toLocalDate(); // gets you the date without time
        ZoneId zoneId = zonedDateTime.getZone(); // gets you the timezone
        System.out.println(zoneId);
        System.out.println(localDate);

        System.out.println("################ Date Utils Example Ended   ###############");
        System.out.println();

    }

}
