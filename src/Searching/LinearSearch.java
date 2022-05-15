package Searching;

import SubmissionFormat.Date_Time;

public class LinearSearch {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(2);

        int[] arr = {10, 20, 30, 40, 50};
        int search = 200;

        linearSearch(arr, search);
    }

    public static void linearSearch(int arr[], int searchElement) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchElement) {
                System.out.println("Element is found at index: " + i);
                return;
            }
        }
        System.out.println("Element is not found in the Array");
    }
}
