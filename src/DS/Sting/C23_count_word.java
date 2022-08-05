package DS.Sting;

import java.util.Arrays;
import java.util.Scanner;

public class C23_count_word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(countWords(input));

    }
    public static int countWords(String str){
        String[] strArr = str.split(" ");
        return strArr.length;
    }
}