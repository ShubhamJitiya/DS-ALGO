package DS.Sting;

import java.util.Arrays;

public class C13_anagrams {
    public static void main(String[] args) {
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        boolean isValidAnagram = usingSort(str1, str2);
        System.out.println(isValidAnagram);
    }

    private static boolean usingSort(String str1, String str2) {

        //Case 1: if both have different length
        if (str1.length() != str2.length()) return false;

        //Convert to char array Sort
        String sortedStr1 = sortString(str1);
        String sortedStr2 = sortString(str2);

        //Check each n every char of string are equal
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;

    }

    private static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}