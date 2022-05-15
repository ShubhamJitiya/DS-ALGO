package StringMatching;
/*
JavaTPoint - Dry Run
GFG - Code
 */

public class C01_NaiveStringMatchingAlgo {
    public static void main(String[] args) {
        String text = "AABAACAADAABAAABAA";
        String pat = "AABA";

        search(text, pat);
    }

    private static void search(String text, String pat) {
        int N = text.length();
        int M = pat.length();

        for (int i = 0; i <= N-M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (text.charAt(i + j) != pat.charAt(j))
                    break;
            }
            //Check whether all characters are matched or not
            if(j==M)
            {
                System.out.println("Pattern found at index: " + i);
            }
        }
    }
}