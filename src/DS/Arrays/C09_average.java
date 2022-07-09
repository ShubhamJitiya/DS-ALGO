package DS.Arrays;

import java.util.stream.IntStream;

public class C09_average {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,5,1};
        System.out.println(usingCollection(arr));


    }
    public static double usingCollection(int[] arr){
        return (double) IntStream.of(arr).sum()/ arr.length;
    }

}