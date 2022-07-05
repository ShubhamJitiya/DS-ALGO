package DS.Arrays;

import java.util.Arrays;

public class C06_inc_dec {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,1};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length/2; i++) {
            System.out.print(arr[i] + " ");
        }
        for (int j = arr.length-1; j >=arr.length/2 ; j--) {
            System.out.print(arr[j] + " ");
        }
    }
}