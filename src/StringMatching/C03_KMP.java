package StringMatching;

class C03_KMP {
    void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)'
        System.out.println("---------Computing LPS Table---------");
        computeLPSArray(pat, M, lps);
        System.out.println("---------Applying KMP---------");

        int i = 0; // index for txt[]
        while (i < N) {
            System.out.println("\ni: " + i + " | j: " + j + " | M: " + M +
                    "\n" + "Text char: " + txt.charAt(i) + " | Pat char: " + pat.charAt(j));
            if (pat.charAt(j) == txt.charAt(i)) {
                System.out.println("Char matches - (Increment j and i)");

                j++;
                i++;
                System.out.println("i: " + i + " | j: " + j);
            }
            if (j == M) {
//                System.out.println("Whole pattern scanned or mismatched?");
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
//                System.out.println("Whole pattern scanned or mismatched?");
                System.out.println("\ni: " + i + " | j: " + j + " | M: " + M +
                        "\n" + "Text char: " + txt.charAt(i) + " | Pat char: " + pat.charAt(j));
                System.out.println("Mismatch | j is not 0 or 0 ?");
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    System.out.println("check prefix/suffix of len: " + lps[j - 1] + " \nCheck char of pattern: " + pat.charAt(lps[j-1]) + " with prev indx-value of lps: " +lps[j - 1]);
                    j = lps[j - 1];
                }
                else {
                    System.out.println("Increment i");
                    i = i + 1;
                }
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
        new C03_KMP().KMPSearch(pat, txt);
    }
}
// This code has been contributed by Amit Khandelwal.