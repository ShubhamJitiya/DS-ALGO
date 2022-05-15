package SubmissionFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Time {
    //Function to Print date, time and practical number

    public Date_Time(int pracNum) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy \nHH:mm:ss");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
        System.out.println("Practical: " + pracNum);
        System.out.println("En: 190130107043");
        System.out.println("------------");
    }
}