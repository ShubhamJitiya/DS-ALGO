package DS.Sting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C17_remove_duplicates {

    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println("Before removing duplicates: " + str);
        usingHashMap(str);
    }

    //Similar to non-repeat in array - remove duplicates
    private static void usingHashMap(String str) {
        Map<Character, Boolean> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), false); //First time occurring
            } else {
                map.put(str.charAt(i), true); //It is repeated
            }
        }
        System.out.print("After removing duplicates: ");
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            System.out.print(entry.getKey() + "");
        }
    }

}