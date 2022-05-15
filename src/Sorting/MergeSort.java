package Sorting;

/*
    Time Complexity: O(nlog(n))
    For all cases
 */

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {50, 40, 30, 20, 10};

        for (int num : arr) {
            System.out.print(num + " ");
        }

        mergeSort(arr, 0, arr.length-1);

        System.out.println();
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void mergeSort(int arr[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int left, int mid, int right) {
        int i = left, j = mid+1, k = left; //base add
//        int temp[] = new int [right];
        int temp[] = new int[arr.length];

        while(i <= mid && j <=right)
        {
            //add the smaller element to temp array k
            if(arr[i] <= arr[j])
            {
                temp[k] = arr[i];
                i++;
                k++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
                k++;
            }
        }
        //if is there any remaining elements in ith array
        while(i<=mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
        //if is there any remaining elements in jth array
        while(j<=mid)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int p = left; p<=right; p++)
            arr[p] = temp[p];
    }
}
