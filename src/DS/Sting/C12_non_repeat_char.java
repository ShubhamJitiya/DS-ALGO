package DS.Sting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C12_non_repeat_char {
    public static void main(String[] args) {
        String str = "google";

        usingHashMap(str);
    }
    //Similar to non-repeat in array
    private static void usingHashMap(String str) {
        List<Character> list = new ArrayList<>();

        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), false); //First time occurring
            } else {
                map.put(str.charAt(i), true); //It is repeated
            }
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (!entry.getValue()) { //If value is false means appeared only once
                list.add(entry.getKey());
            }
        }
        System.out.println(list);
     /*   for(Map.Entry<Integer, Boolean> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }*/

    }
}