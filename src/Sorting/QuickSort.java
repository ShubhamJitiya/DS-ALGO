package Sorting;

/*
    Time Complexity: O(n^2)
 */


public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};

        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, arr.length - 1);

        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int mid = partition(arr, start, end);

            quickSort(arr, start, mid - 1);
            quickSort(arr, mid + 1, end);

        }
    }

    public static int partition(int arr[], int start, int end) {
        int pivotElement = arr[end];
        int pivotIndex = start;

        for (int i = start; i<end; i++)
        {
            if(arr[i]<=pivotElement);
        }
        return 0;
    }
}