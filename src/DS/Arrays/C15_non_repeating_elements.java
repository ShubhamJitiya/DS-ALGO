package DS.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C15_non_repeating_elements {
    public static void main(String[] args) {
        int[] arr =  {1,1,2,3,4,4,5,2};

        usingHashMap(arr);
    }
    private static void usingHashMap(int[] arr) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){ //vising first time
                map.put(arr[i], false);
            }else{
                map.put(arr[i], true); //visiting second time
            }
        }

        for(Map.Entry<Integer, Boolean> entry : map.entrySet()){
            if(!entry.getValue()) { //If value is false means that appeared only once
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
        System.out.println(list);
     /*   for(Map.Entry<Integer, Boolean> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/

    }
}