package DS.Sting;

import java.util.Scanner;

public class C21_largest_word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = sc.nextLine();
        System.out.println(largestWord(inputString));
    }

    public static String largestWord(String str){
        String[] strArray = str.split(" ");
        String max = "";
        for (int i = 0; i < strArray.length; i++) {
            if(strArray[i].length() > max.length())
                max = strArray[i];
        }
        return max;
    }
}