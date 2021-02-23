package problem_19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSundays {
    public static void main(String[] args) {
        int day = 1;
        int dayName = 2;
        int year = 1901;
        int numSundays = 0;
        Integer[] YearMonths = {1, 32, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        Integer[] LeapYearMonths = {1, 32, 61, 92, 122, 153, 183, 214, 245, 275, 306, 336};
        List<Integer> monthDays = Arrays.asList(LeapYearMonths);
        while(true) {
            if((day == 366 && (year % 4 != 0 || year % 400 == 0))) {
                year++;
                day = 1;
                monthDays = Arrays.asList(YearMonths);
            } 
            else if (day == 367) {
                year++;
                day = 1;
                monthDays = Arrays.asList(LeapYearMonths);
            }

            if(year == 2001) {

                break;
            }

            if(monthDays.contains(day) && dayName == 7) {
                numSundays ++;
                System.out.println(numSundays + " " + year + " " + day);
            
            }

            if(dayName == 7) {
                dayName = 1;
            } else {
                dayName ++;
            }
            day++;
        }
        System.out.println(numSundays);
        System.out.println("meow");
    }
}
