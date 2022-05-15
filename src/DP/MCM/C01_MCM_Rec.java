package DP.MCM;

public class C01_MCM_Rec {
    public static void main(String[] args) {

        int [] arr = new int[] {1,2,3,4,3};
        int n = arr.length;

        System.out.println("Minimum Number of multiplication is: " + solve(arr, 1, n-1));
    }

    public static int solve(int[] arr, int i, int j)
    {
        int min = Integer.MAX_VALUE;

        if(i >= j)
            return 0;

        for (int k = i; k <= j-1; k++) { //OR k = i + 1 to j
            int tempAns = solve(arr, i, k) + solve(arr, k+1, j) // OR i to k-1 + k to j
                         + arr[i-1] * arr[k] * arr[j] ; //OR arr[k-1]
            if(tempAns < min)
                min = tempAns;
        }
     return min;
    }
}


/*

MCM - Approach

arr[]

1. i & j
2. BC
3. k loop Schema
4. calculate cost for temp ans
 */