package DS.Arrays;

import java.util.Arrays;

public class C03_second_smallest_largest {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1, 1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        approach1(arr);
        approach2(arr);
    }

    //not work in case of duplicate - using sorting
    private static void approach1(int[] arr) {
        int secondSmallest, secondLargest;
        Arrays.sort(arr);
        System.out.println("\nSecond smallest: " + arr[1] + "\nSecond largest: " + arr[arr.length - 2]);
    }

    ///work in case of duplicate - without sorting - traverse twice
    private static void approach2(int[] arr) {
        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE, firstLargest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            firstSmallest = Math.min(firstSmallest, arr[i]);
            firstLargest = Math.max(firstLargest, arr[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < secondSmallest && arr[j] != firstSmallest)
                secondSmallest = arr[j];
            if (arr[j] > secondLargest && arr[j] != firstLargest)
                secondLargest = arr[j];
        }
        System.out.println("\nSecond smallest: " + secondSmallest + "\nSecond largest: " + secondLargest);
    }

    //Best Solution
    static private int secondSmallest(int[] arr, int n) {
        if (n < 2) {
            return -1;
        }
        int small = Integer.MAX_VALUE;
        int second_small = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] < small) {
                second_small = small;
                small = arr[i];
            } else if (arr[i] < second_small && arr[i] != small) {
                second_small = arr[i];
            }
        }
        return second_small;
    }
    static private int secondLargest(int[] arr, int n) {
        if (n < 2)
            return -1;
        int large = Integer.MIN_VALUE;
        int second_large = Integer.MIN_VALUE;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] > large) {
                second_large = large;
                large = arr[i];
            } else if (arr[i] > second_large && arr[i] != large) {
                second_large = arr[i];
            }
        }
        return second_large;
    }

}