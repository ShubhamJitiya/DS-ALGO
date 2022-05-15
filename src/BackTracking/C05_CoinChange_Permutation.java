package BackTracking;

public class C05_CoinChange_Permutation {
    static int count;
    public static void main(String[] args) {
        coinChangePermutation(new int[]{2, 3, 5, 6}, 10, "");
    }

    public static void coinChangePermutation(int[] denom, int amount, String ans) {
        if (amount == 0) {
            count++;
            System.out.println(count +  ". "+ ans);
            return;
        }

        //Base condition for neg. or check before calling fn
        if(amount < 0)
            return;

        for (int i = 0; i < denom.length; i++) {
//            if (amount >= denom[i]) //check before calling fn or write neg. base case
                coinChangePermutation(denom, amount - denom[i], ans + denom[i]);

        }
    }
}