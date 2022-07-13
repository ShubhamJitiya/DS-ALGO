package DS.Sting;

public class C16_max_repeat_char {
    //ASCII value is index of count array
    //Increase the occurrence of current char by 1
    // Find max count & store current char in ans


    static char maxOccurringChar(String str) {
        char ans = 0; //null
        int[] count = new int[256];
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            count[currentChar]++;
            if (count[currentChar] > max) {
                max = count[currentChar];
                ans = currentChar;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "apple";
        System.out.println("Original String: " + str);
        System.out.println("Maximum occurring character is " + maxOccurringChar(str));
    }
}