
class test {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
        }
        System.out.println("---- LPS/PI table is: -----");
        for (int pi: lps
        ) {
            System.out.print(pi + " ");
        }
    }

    void computeLPSArray(String pat, int M, int lps[]) {
        System.out.println("Computing LPS");
        System.out.println("------------\n");
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            System.out.println("Current char: " + pat.charAt(i) + " and Char of len: " + pat.charAt(len));
            System.out.println("len: " + len + "    |   lps[i]: " + lps[i-1] + "    |     i: " + i);
            if (pat.charAt(i) == pat.charAt(len)) {
                System.out.println("Matches (Increment len, Store value of len in current lps, Increment i)");
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                System.out.println("Does not matches: Checking len != 0 or len == 0");
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    System.out.println("len != 0 (update len: lps[len - 1] and match again) ");
                    len = lps[len - 1];

                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    System.out.println("len == 0 (Store 0 to current lps - First time occurring)");
                    lps[i] = len;
                    i++;
                }
            }
            System.out.println();
        }

    }

    // Driver program to test above function
    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new test().KMPSearch(pat, txt);
    }
}
// This code has been contributed by Amit Khandelwal.