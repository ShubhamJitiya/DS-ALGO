package DP.knapsack;

import SubmissionFormat.Date_Time;

public class C02_knapsack_DP {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(5);

        int val[] = {1,6,18,22,28}; //
        int wt[] = {1,2,5,6,7}; //Quantity of GSP

        int W = 7; //Total downloads
        int n = val.length;
        knapSack(W, wt, val, n);

    }

    public static void knapSack(int W, int[] wt, int[] val, int n) {

//        t - DP Matrix table
        int[][] t = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;
                else if (wt[i - 1] <= j) //Weight of item must be less than current capacity
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]],
                            t[i - 1][j]); //Consider max of (selected(add val + decrease current capacity), not selected (above value))
                //Consider max of (selected, not selected)
                //j = Capacity of kanpsack
                //i-1 as counted, now we can exclude this item
                //wt weight of current item
                else
                    t[i][j] = t[i - 1][j];

            }

        }
        System.out.println("Maximum Value:\t" + t[n][W]);

        System.out.println("\nSelected Packs: ");

        while (n != 0) {
            if (t[n][W] != t[n - 1][W]) {
                System.out.println("Pack " + n + " with weight = " + wt[n - 1] + " and value = " + val[n - 1]);
                W = W - wt[n - 1];
            }
            n--;
        }
    }
}