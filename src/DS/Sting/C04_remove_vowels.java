package DS.Sting;

import java.util.HashMap;
import java.util.Map;

public class C04_remove_vowels {
    public static void main(String[] args) {
        String str = "take u forward";

        System.out.println(usingStringBuilder(str.toLowerCase()));
    }
    private static StringBuilder usingStringBuilder(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //If vowel then skip else append in new string
            if(      str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u'
            ){
                continue;
            }
                newString.append(str.charAt(i));
        }
        System.out.println();
        return newString;

    }

}