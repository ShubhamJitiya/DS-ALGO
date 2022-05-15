package Resursion;

import SubmissionFormat.Date_Time;

public class Factorial_Iterative {
    // Driver method
    public static void main(String[] args) {
        Date_Time format = new Date_Time(4);

        int num = 5;
        System.out.println(
                "Factorial of " + num
                        + " is " + factorial(5));
    }

    // Method to find factorial of the given number
    static int factorial(int n) {
        int res = 1, i;
        for (i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
