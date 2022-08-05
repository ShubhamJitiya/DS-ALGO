package DS.Sting;

public class C28_reverse_words {
    public static void main(String[] args) {
        String input = "TUF is great for interview preparation";
        System.out.println(reverseWords(input));

    }
    public static String reverseWords(String words) {
        StringBuffer result = new StringBuffer();
        String[] wordsArray = words.split(" ");
        for (int i = wordsArray.length - 1; i >= 0; i--) {
            result.append(wordsArray[i]).append(" ");
        }
        return result.toString();
    }
}