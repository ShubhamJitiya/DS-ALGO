package DS.Arrays;

import java.util.HashMap;
import java.util.Map;

public class C05_count_frequency {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,4,5};
        approach1(arr);
    }
    private static void approach1(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else {
                map.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}