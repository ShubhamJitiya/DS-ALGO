package BackTracking;

public class C04_CoinChange_Combination {
    static int count = 0;

    public static void main(String[] args) {
        CoinChangeCombination(new int[]{2, 3, 5, 6}, 10, "", 0);

    }
    public static void CoinChangeCombination(int[] denom, int amount, String ans, int lastDenomIndx)
    {
        if(amount == 0) {
            System.out.println(ans);
            return;
        }
        for (int i = lastDenomIndx; i <denom.length; i++) {
            if(amount>=denom[i])
                CoinChangeCombination(denom, amount - denom[i], ans+denom[i], i);
        }
    }
}