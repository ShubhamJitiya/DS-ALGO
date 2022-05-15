package DP.MCM;

import SubmissionFormat.Date_Time;

import java.util.Arrays;

public class C02_MCM_Mem {
    static int t[][] = new int[100][100];

    public static void main(String[] args) {
        Date_Time format = new Date_Time(6);

        int[] arr = new int[]{10, 100, 20, 5, 80};
        int n = arr.length;

        for (int[] row: t)
            Arrays.fill(row, -1);
        System.out.println("Minimum Number of multiplication is: " + solve(arr, 1, n - 1));

    }

    public static int solve(int[] arr, int i, int j) {
        int min = Integer.MAX_VALUE;

        if (i >= j)
            return 0;
        if (t[i][j] != -1)
        {
            return t[i][j];
        }

        for (int k = i; k <= j - 1; k++) { //OR k = i + 1 to j
            int tempAns = solve(arr, i, k) + solve(arr, k + 1, j) // OR i to k-1 + k to j
                    + arr[i - 1] * arr[k] * arr[j]; //OR arr[k-1]
            if (tempAns < min)
                min = tempAns;
        }
        return t[i][j] = min;
    }

}
