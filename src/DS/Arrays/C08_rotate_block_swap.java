package DS.Arrays;

import javax.swing.*;

/*
* peep coding
*   https://www.youtube.com/watch?v=8RErc0VXAo8&t=5s
* THIS MAY NOT BE THE BLOCK SWAP ALGORITHM
* */
public class C08_rotate_block_swap {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int rotateBy = -1;

        //reverse(arr, arr.length-1);
        print(arr);
        System.out.println();

        rotation(arr, rotateBy);

        print(arr);

    }

    private static void rotation(int[] arr, int rotateBy) {
        int k = rotateBy % arr.length;
        if(k < 0){
            k = k + arr.length;
        }

        //part - 1
        reverse(arr, 0, arr.length - k - 1);

        //part - 2
        reverse(arr, arr.length - k, arr.length - 1);

        //all
        reverse(arr, 0, arr.length - 1);

    }

    private static void reverse(int[] arr, int startIndex, int endIndex) {
        int p1 = startIndex, p2 = endIndex;
        while(p1<p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }
    private static void print(int[] arr){
        for(int i: arr){
            System.out.print(i + ", ");
        }
    }
}