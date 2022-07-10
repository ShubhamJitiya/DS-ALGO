package DS.Sting;

import java.util.HashMap;
import java.util.Map;

public class C02_count_VCS {
    public static void main(String[] args) {
        String str = "India won the cricket match";
        System.out.println(str.length());
        usingHashmap(str);
    }

    private static void usingHashmap(String str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            //If vowel
            if(        str.charAt(i) == 'A' || str.charAt(i) == 'a'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'e'
                    || str.charAt(i) == 'I' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'O' || str.charAt(i) == 'o'
                    || str.charAt(i) == 'U' || str.charAt(i) == 'u'
            ){
                if(!map.containsKey("Vowels"))
                    map.put("Vowels", 1);
                else
                    map.put("Vowels", map.get("Vowels") + 1);
            } else if(str.charAt(i) == ' '){ //if space
                if(!map.containsKey("Spaces"))
                    map.put("Spaces", 1);
                else
                    map.put("Spaces", map.get("Spaces") + 1);
            }else //If string should not contain number or symbols
            if(!map.containsKey("Consonants"))
                map.put("Consonants", 1);
            else
                map.put("Consonants", map.get("Consonants") + 1);

        }
        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}