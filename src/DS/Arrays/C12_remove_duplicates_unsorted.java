package DS.Arrays;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C12_remove_duplicates_unsorted {
    public static void main(String[] args) {
        int[] arr = {2,3,1,9,3,1,3,9};
        int len = removeDuplicatesUnsorted(arr);
       /* for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + ", ");

        }*/
        usingHashMap(arr);
    }

    //1. sort & use remove duplicate from sorted
    private static int removeDuplicatesUnsorted(int[] arr) {
        Arrays.sort(arr);

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if(arr[i] != arr[j]){
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;

    }

    //2. using hashmap store key if not present
    private static void usingHashMap(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                //System.out.print(arr[i] + ", ");
                map.put(arr[i],1);
            }
        }

        //Traverse map
        for (Map.Entry<Integer, Integer> mp: map.entrySet()){
            System.out.print(mp.getKey() + ", ");
        }
    }
}