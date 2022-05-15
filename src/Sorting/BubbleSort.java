package Sorting;
/*
    Time Complexity: O(n^2)
 */

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};

        for (int num : arr) {
            System.out.print(num + " ");
        }

        bubbleSort(arr);

        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
