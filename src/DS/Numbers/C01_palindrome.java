package DS.Numbers;

public class C01_palindrome {
    static int reverse(int num) {
        int Y = 0;
        while (num > 0) {
            System.out.println();

            //Extract the last digit
            int lastDigit = num % 10;
            System.out.println("Extract Last: " + lastDigit);

            //Appending last digit
            System.out.print("Append end: " + Y*10 +"+" + lastDigit + " | ");
            Y = Y * 10 + lastDigit;
            System.out.println( " | " + Y);

            // Shrinking X by discarding the last digit
            num = num / 10;
            System.out.println("Remove last : " + num);
        }
        return Y;
    }

    public static void main(String[] args) {

        int originalNum = 121;
        int reversedNum = reverse(originalNum);

        if (reversedNum == originalNum) {
            System.out.println("Palindrome Number");
        }
        else {
            System.out.println("Not Palindrome Number");
        }
    }
}