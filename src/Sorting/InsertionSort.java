package Sorting;
/*
    Time Complexity: O(n^2)
 */

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};

        for (int num : arr) {
            System.out.print(num + " ");
        }

        insertionSort(arr);

        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertionSort(int arr[]) {
        int key = 0, j = 0;

        for (int i = 0; i < arr.length; i++) {
            //Take First element as key
            key = arr[i];
            //Set j one less than current element
            j = i - 1;

            //If there some elements present on LHS and current element is greter than key - SWAP
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            //place key element to it's current position
            arr[j + 1] = key;
        }
    }
}
