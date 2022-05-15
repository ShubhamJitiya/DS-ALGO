package DP.LCS;
import SubmissionFormat.Date_Time;


class C01_LCS_Rec {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(12);

        String x = "qpqrr";
        String y = "pqprqrp";

        char[] X = x.toCharArray();
        char[] Y = y.toCharArray();

        int lengthX = X.length;
        int lengthY = Y.length;

        int ans = LCS(X, Y, lengthX, lengthY);
        System.out.println(ans);
    }

    private static int LCS(char[] X, char[] Y, int n, int m) {

        //Base condition
        if(n==0 || m == 0)
            return 0;

        //Choice diagram
        if(X[n-1] == Y[m-1])
            return 1+LCS(X, Y, n-1, m-1);
        else
        {
            return Math.max(LCS(X, Y, n, m-1), LCS(X, Y, n-1, m));
        }
    }
}
