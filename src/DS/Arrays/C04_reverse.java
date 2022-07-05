package DS.Arrays;

public class C04_reverse {
    public static void main(String[] args) {
        int[] arr = {1, 1,2,3,4,5};
        approach2(arr);
        print(arr);

    }

    private static void approach1(int[] arr) {
        int p1 = 0, p2 = arr.length - 1;
        while(p1<p2){
            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;
        }
    }

    private static void approach2(int[] arr){
        for (int i = 0; i < (arr.length ) / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");

        }
    }
}