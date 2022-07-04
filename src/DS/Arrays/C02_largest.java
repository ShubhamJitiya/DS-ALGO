package DS.Arrays;

import java.util.Arrays;

public class C02_largest {
    public static void main(String[] args){
        int[] arr = {5,4,3,2,1};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\nLargest: " + approach1(arr));
        System.out.println("Largest: " + approach2(arr));
    }

    private static int approach2(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }

    private static int approach1(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}