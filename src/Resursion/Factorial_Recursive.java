package Resursion;

import SubmissionFormat.Date_Time;

public class Factorial_Recursive {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(4);

        int num = 5;
        System.out.println("Factorial of " + num
                + " is " + factorial(5));
    }

    // method to find factorial of given number
    static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }
}
