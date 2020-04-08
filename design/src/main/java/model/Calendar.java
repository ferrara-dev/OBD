package model;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Calendar {
    static private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    static private LocalDateTime now;

    public static String getTimeAndDate(){
        now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static int getAge(String id){
        now = LocalDateTime.now();
        dtf.format(now);
        StringBuilder sb = new StringBuilder(id);

        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);  //Birth date
        Period p = Period.between(birthday, today);

        return p.getYears();
    }

    public static String getNextDate(){
        LocalDate today = LocalDate.now();
        return today.plusDays(1).toString();
    }


    public static String getCurrentDate(){
        LocalDate today = LocalDate.now();
        return today.toString();
    }
    public static List<String> getDatesBetween(String startDate, String endDate){
        List<String> dates = new ArrayList<>();
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end   = LocalDate.parse(endDate);
        LocalDate next = start.minusDays(1);
        while ((next = next.plusDays(1)).isBefore(end.plusDays(1))) {
            dates.add(next.toString());
            System.out.println(next);
        }
        return dates;
    }


    public static DayOfWeek getDayOfTheWeek(){
        now = LocalDateTime.now();

        return DayOfWeek.from(now);
    }
}
