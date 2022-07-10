package DS.Sting;

public class C09_sum {
    public static void main(String[] args) {
        String str = "1bc268";
        System.out.println( findSum(str));
    }

    private static int findSum(String str) {
        String tempSum = "0";
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);

            if (Character.isDigit(s))
                tempSum += s;

            else {
                System.out.println(sum + " + " + tempSum + " = " + sum + Integer.parseInt(tempSum));
                sum += Integer.parseInt(tempSum);
                tempSum = "0";
            }
        }
        System.out.println(sum + " + " + tempSum + " = " + sum + Integer.parseInt(tempSum));


        return sum + Integer.parseInt(tempSum);
    }
}