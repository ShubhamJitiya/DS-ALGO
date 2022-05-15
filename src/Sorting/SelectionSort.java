package Sorting;

/*
    Time Complexity: O(n^2)
 */

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};

        for (int num : arr) {
            System.out.print(num + " ");
        }

        selectionSort(arr);

        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length-1; i++) {
            //Set current element as minimum
            int minIndex = i;

            //Finds element which is min than min
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //Swap minimum element and current element if they are on different index
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
}
