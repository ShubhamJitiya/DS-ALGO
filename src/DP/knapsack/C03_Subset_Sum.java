package DP.knapsack;

import java.util.Scanner;

public class C03_Subset_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int tar = sc.nextInt();
        boolean [][] dp = new boolean[n+1][tar+1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                //First row = false
                if (i == 0)
                    dp[i][j] = false;
                    //First column = True (0,0 false will convert to true)
                else if (j == 0)
                    dp[i][j] = true;
                else if(arr[i - 1] <= j) //Weight of item must be less than capacity
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        System.out.println(dp[arr.length][tar]);
    }
}
