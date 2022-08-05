package DS.Sting;

import java.util.*;

public class C22_sort_char_string {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        char[] sortedStringChar = sortCharString(input);
        System.out.println(sortedStringChar);

    }
    public static char[] sortCharString(String str){
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return charArr;
    }
}