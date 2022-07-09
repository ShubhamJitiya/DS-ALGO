package DS.Arrays;

import static DS.Arrays.C04_reverse.print;

public class C13_insert_beg {
    public static void main(String[] args) {
        int[] arr = {10,9,14,8,20,48,16,9,0};
        print(arr);
        System.out.println();
//        insertAtBeginning(arr, 5,200);
//        insertAtEnd(arr, 5, 200);
        insertAtIndex(arr, 8, 4, 5);
        print(arr);
    }


    private static void insertAtBeginning(int[] arr, int length, int value) {
        for (int i = length - 1; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = value;
    }

    private static void insertAtEnd(int[] arr, int length, int value) {
        arr[length] = value;
    }

    private static void insertAtIndex(int[] arr, int length, int value, int index) {
  /*      int i = length - 1;
        while(i != index && i>=0){
            arr[i+1] = arr[i];
            i--;
        }
        arr[index] = value;*/

        for (int i = length - 1; i != index; i--) {
            arr[i + 1] = arr[i];
        }
        arr[index] = value;
    }

}