package DP;

public class BinomialCoefficient {
    public static void main(String[] args) {
        int n = 5, k = 2;

        System.out.printf("Value of C (%d, %d) is %d ", n, k, binomialCoeff(n, k));
    }

    private static int binomialCoeff(int n, int k) {
        int C[] = new int[k + 1];

        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            //compute next row of pascal triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--) {
                C[j] = C[j] + C[j - 1];
            }
        }
        return C[k];
    }

}
