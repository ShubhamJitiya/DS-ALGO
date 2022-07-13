package DS.Numbers;

public class C02_all_palindrome {
    public static void main(String[] args) {
       int start = 0, end = 33;
       for(int i = start; i <=end; i++)
           System.out.println(isPalindrome(i));
    }

    private static boolean isPalindrome(int originalNum) {
        int reversed = 0;
        int copyNum = originalNum;
        while(copyNum > 0){

            //Extract last digit
            int extract = copyNum % 10;
            //Append
            reversed = reversed*10 + extract;
            //Remove last digit
            copyNum = copyNum / 10;
        }
        if(originalNum == reversed) {
            System.out.println(originalNum);
            return true;
        }
        else {
            return false;
        }
    }
}