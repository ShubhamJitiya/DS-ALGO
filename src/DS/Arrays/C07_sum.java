package DS.Arrays;

import java.util.stream.IntStream;

/*
    Calculate Sum of the Elements of the Array:
        https://takeuforward.org/arrays/calculate-sum-of-the-elements-of-the-array/
*/
public class C07_sum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Sum of elements in array: " + iterative(arr));
        System.out.println("Using collection: " + usingCollection(arr));

    }
    public static int iterative(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int usingCollection(int[] arr){
        return IntStream.of(arr).sum();
    }
}