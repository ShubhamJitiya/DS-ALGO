package DS.Arrays;

import java.util.Arrays;

public class C10_median {
    public static void main(String[] args) {
        int[] arr = {2,4,1,3,5};
        Arrays.sort(arr);
        int n = arr.length;
        System.out.println("Median: " + median(arr, n));

    }
    private static float median(int[] arr, int n){
        float ans;
        if(n%2 == 0){
            int ind1 = n/2 -1;
            int ind2 = n/2;
            ans = (float) (arr[ind1] + arr[ind2]) / 2;
        }else{
            ans = arr[n/2];
        }
        return ans;
    }
}