package DS.Sting;

import java.util.HashMap;
import java.util.Map;

public class C13_char_frequency {
    public static void main(String[] args) {
        String str = "takeuforward";

        countFrequency(str);
    }

    private static void countFrequency(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if(!map.containsKey(currentChar))
                map.put(currentChar, 1);
            else
                map.put(currentChar, map.get(currentChar)+1);

        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            System.out.print (entry.getKey() + ""+ entry.getValue() + " ");
        }
    }
}