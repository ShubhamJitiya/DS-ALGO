package DS.Arrays;

public class C11_remove_duplicates_sorted {
    public static void main(String[] args) {
        int[] arr ={1,1,2,2,2,3,3};
        int n = removeDuplicatesSorted(arr);
        System.out.println("Size: " + n);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]  + ", ");
        }
    }
    public static int removeDuplicatesSorted(int[] arr){
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[i]!=arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}