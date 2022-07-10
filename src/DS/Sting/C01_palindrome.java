package DS.Sting;

public class C01_palindrome {
    public static void main(String[] args) {
        String str = "Madam";
        System.out.println(isPalindrome2(str.toLowerCase()));
    }

    private static boolean isPalindrome1(String str) {
        //Similar to reverse
        int p1 = 0, p2 = str.length() - 1;
        while(p1 < p2){
            if(str.charAt(p1) != str.charAt(p2)) return false;
            p1++;
            p2--;
        }
        return true;
    }
    private static boolean isPalindrome2(String str) {
        //Similar to reverse
        int length = str.length();
        for (int i = 0; i < length/2; i++) {
            if(str.charAt(i) != str.charAt(length - i - 1))  return false;
        }
        return true;
    }
}