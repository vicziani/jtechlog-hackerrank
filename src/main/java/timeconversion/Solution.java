package timeconversion;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Solution {

    public String timeConversion(String s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ssa", Locale.ENGLISH);
        LocalTime time = LocalTime.parse(s, formatter);
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }
}
