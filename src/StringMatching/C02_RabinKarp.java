package StringMatching;

public class C02_RabinKarp {
    // d is the number of characters in the input alphabet
    public final static int d = 10;

    /* pat -> pattern
        txt -> text
        q -> A prime number
    */
    static void search(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }
        System.out.println("Hash code h: " + h);
        System.out.println("Hash value of Pattern: " + p);
        System.out.println("Hash value of first window: " + t);
        System.out.println();


        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {
            System.out.println("iteration: " + i);
            System.out.println("Hash value of Pattern: " + p);
            // Check the hash values of current window of text
            // and pattern. If the hash values match then only
            // check for characters on by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M)
                    System.out.println("Pattern found at index " + i);
            }

            // Calculate hash value for next window of text: Remove
            // leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;
                System.out.println("Hash value of next window: " + t);

                // We might get negative value of t, converting it
                // to positive
                if (t < 0) {
                    t = (t + q);
                    System.out.println("Negative converted to Positive: " + t);
                }
            }
            System.out.println();
        }
    }

    /* Driver Code */
    public static void main(String[] args) {
        String txt = "3141592653589793";
        String pat = "26";

        // A prime number
        int q = 101;

        // Function Call
        search(pat, txt, 11);
    }
}

// This code is contributed by nuclode