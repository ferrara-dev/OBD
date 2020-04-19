package util;



import java.time.*;
import java.time.format.DateTimeFormatter;
<<<<<<< HEAD:design/src/main/java/model/Calendar.java

import java.util.ArrayList;
import java.util.List;

=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> origin/master:design/src/main/java/util/Calendar.java

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
        int year = sb.charAt(0);


        LocalDate today = LocalDate.now();                          //Today's date
        LocalDate birthday = LocalDate.of(94, Month.JANUARY, 1);  //Birth date
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

    public static List<String> getDatesBetween(String startDate){
        List<String> dates = new ArrayList<>();
        LocalDate start = LocalDate.parse(startDate);
        //LocalDate end   = LocalDate.parse(endDate);
        LocalDate nextYear = start.plusYears(1);
        LocalDate next = start.minusDays(1);

        while ((next = next.plusDays(1)).isBefore(nextYear)) {
            dates.add(next.toString());
        }
        return dates;
    }

    public static DayOfWeek getDayOfTheWeek(){
        now = LocalDateTime.now();

        return DayOfWeek.from(now);
    }
}
