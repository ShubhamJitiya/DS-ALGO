package DS.Arrays;

import java.util.HashMap;
import java.util.Map;

public class C14_repeating_elements {
    public static void main(String[] args) {
        int[] arr =  {1,1,2,3,4,4,5,2};

        usingHashMap(arr);

    }

    private static void usingHashMap(int[] arr) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){

                map.put(arr[i], true);
            }
        }
        for(Map.Entry<Integer, Boolean> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}