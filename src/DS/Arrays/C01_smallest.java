package DS.Arrays;

import java.util.Arrays;

public class C01_smallest {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\nSmallest: " + approach1(arr));
        System.out.println("Smallest: " + approach2(arr));
    }

    //O(n)
    private static int approach2(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    //O0(nlogn)
    private static int approach1(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }

}