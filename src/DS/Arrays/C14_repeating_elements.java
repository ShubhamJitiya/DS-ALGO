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
        for (int j : arr) {
            if (!map.containsKey(j)) {
                map.put(j, false); //First time occurring
            } else {
                map.put(j, true); //It is repeated
            }
        }
        for(Map.Entry<Integer, Boolean> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}