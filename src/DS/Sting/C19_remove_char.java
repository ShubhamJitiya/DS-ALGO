package DS.Sting;

import java.util.HashMap;
import java.util.Map;

/*
* Remove characters from string 1
* present in string 2
* */
public class C19_remove_char {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "cefz";

        System.out.println("Final string 1:");
        System.out.println(removeCharacters(str1, str2));
    }
    public static String removeCharacters(String str1, String str2){
        StringBuffer newStr = new StringBuffer();
        Map<Character,Boolean> secondString = new HashMap<>();

        for(int i = 0; i < str2.length(); i++){
            secondString.put(str2.charAt(i), true); //Append all unique character of string 2
        }

        for (int i = 0; i < str1.length(); i++) {
            if(!secondString.containsKey(str1.charAt(i))){
                newStr.append(str1.charAt(i));
            }
        }
        return newStr.toString();
    }
}