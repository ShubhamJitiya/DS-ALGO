//0/1 Knapsack - Recursive- Memoization
//Memoization - Skip if it is already solved earlier


package DP.knapsack;

public class C01_knapsack_0_1_rec_memo {

    public static void main(String[] args) {

        int val[] = {70, 80, 90, 200};
        int wt[] = {20, 30, 40, 70};

        int W = 60;
        int N = val.length;

        System.out.println(knapsack(W, wt, val, N));
    }

    static int knapsackRec(int W, int wt[], int val[], int n, int[][] dp) {
        //Base condition
        if (n == 0 || W == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        //If we wt is less than Capacity (W) we have two choices
        //Select or not
        if (wt[n - 1] <= W) {
            //Include item
            int op1 = val[n - 1] + knapsackRec(W - wt[n - 1], wt, val, n - 1, dp);

            //Exclude item
            int op2 = knapsackRec(W, wt, val, n - 1, dp);

            return dp[n][W] = Math.max(op1, op2);
        }
        //If wt of item is greater than Capacity (W) we can't select it
        else
            return dp[n][W] = knapsackRec(W, wt, val, n - 1, dp);
    }

    static int knapsack(int W, int[] wt, int[] val, int N) {
        //Declare the table dynamically
        int[][] dp = new int[N + 1][W + 1];

        //Loop to initially filled the table with -1
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }
        return knapsackRec(W, wt, val, N, dp);
    }
}
