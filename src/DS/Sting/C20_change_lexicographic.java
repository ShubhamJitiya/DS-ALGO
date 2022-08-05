package DS.Sting;

import java.util.*;

public class C20_change_lexicographic {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = "abcdxyz";
        System.out.println(changeLexicographic(input, input.length()));

    }

    public static String changeLexicographic(String str, int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int currentCh = str.charAt(i);

            if(currentCh == 90) //Z
                stringBuffer.insert(i,(char) 65);
            else if(currentCh == 122) //z
                stringBuffer.insert(i, (char) 97);
            else if(currentCh >= 65 && currentCh < 90 || currentCh >= 97 && currentCh < 122)
                stringBuffer.insert(i,(char) (currentCh + 1));
        }
        return stringBuffer.toString();
    }

}