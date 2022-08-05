package DS.Sting;

import java.sql.SQLOutput;

public class C24_word_greatest_repeating_letters {
    public static void main(String[] args) {
        String input = "cameron blue";

        //Traverse each word in string
     /*   for(String c : input.split(" "))
        {
            System.out.print(c + ", ");
        }
*/

      /*  //Traverse each character in String
        for(char c : input.toCharArray())
        {
            System.out.print(c + ", ");
        }*/
        int maxRCI = 0;
        String maxWord = "";

        for (String str : input.split(" ")) {
            int currentMax = findMaxChar(str);

            if (currentMax > maxRCI) {
                maxRCI = currentMax;
                maxWord = str;
            }
        }


        if(maxRCI == 0){
            System.out.println("Not Found");
        }else
        {
            System.out.println(maxRCI + " "+ (char)maxRCI);
            System.out.println(maxWord);
        }

    }

    public static int findMaxChar(String str) {
        int[] ascii = new int[256];
        int maxRepeatingCharIndex = 0;
        int maxCount = 0;
        int totalCount = 0;

        for (char c : str.toCharArray()) {
            ascii[c]++;
            if(ascii[c] > 1)
                totalCount++;
            if (ascii[c] > ascii[maxRepeatingCharIndex]) {
                maxRepeatingCharIndex = c;
            }
        }
        if(totalCount > 1)
            return totalCount;
        else
            return -1;
    }
}