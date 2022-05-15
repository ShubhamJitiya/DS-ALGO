package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class CountSort {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int []arr =  new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        System.out.println(Arrays.toString(arr));
    }

    private static void countSort(int[] arr, int min, int max) {
        int range = max - min + 1;
        int[] farr = new int[range];

        //Frequency array
        for (int i = 0; i<arr.length; i++)
        {
            int idx = arr[i] - min;
            farr[idx]++;
        }

        //Prefix sum array - stability
        for(int i = 1; i<farr.length; i++)
        {
            farr[i] = farr[1] + farr[i-1];
        }

        //Sort array - scan reverse
        int []ans = new int[arr.length];
        for (int i = arr.length; i >=0; i--) {
            int val = arr[i];
            int pos = farr[val-min];
            int idx = pos-1;

            ans[idx] = val;
            farr[val - min]--;
        }
        for (int i = 0; i<ans.length; i++)
        {
            arr[i] = ans[i];
        }
    }
}
