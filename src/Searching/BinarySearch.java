package Searching;

import SubmissionFormat.Date_Time;

public class BinarySearch {
    public static void main(String[] args) {
        Date_Time format = new Date_Time(2);

        int[] arr = {10, 20, 30, 40, 50};
        int search = 50;

        if (binarySearch(arr, search)!=-1)
        {
            System.out.println("Element is found at Index " + binarySearch(arr, search));
        }
        else
        {
            System.out.println("Element is not found");
        }
    }

    public static int binarySearch(int[] arr, int searchElement) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
            int mid = (startIndex + endIndex) / 2;

            if (searchElement == arr[mid])
                return mid;
            else if (searchElement < arr[mid]) //Element which I want is on left hand side
                endIndex = mid - 1;
            else //Element which I want is on right hand side
                startIndex = mid + 1;
        }
        return -1;
    }
}
