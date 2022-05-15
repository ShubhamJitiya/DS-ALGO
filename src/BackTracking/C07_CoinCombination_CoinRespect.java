package BackTracking;

public class C07_CoinCombination_CoinRespect {
    public static void main(String[] args) {
        coinChangeCombinationCoinRespect(new int[]{1, 2, 3, 4}, 0, 4, "");

    }

    public static void coinChangeCombinationCoinRespect(int[] denom, int vindx, int amount, String ans) {

        //positive base case
        if(amount == 0)
        {
            System.out.println(ans);
            return;
        }
        //neg base case
        if (amount < 0 || vindx == denom.length)
        {
            return;
        }

        //Yes
        coinChangeCombinationCoinRespect(denom, vindx, amount - denom[vindx], ans + denom[vindx]);
        //No
        coinChangeCombinationCoinRespect(denom, vindx+1, amount, ans);
    }
}