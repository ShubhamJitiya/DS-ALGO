package DS.Sting;

public class C05_remove_spaces {
    public static void main(String[] args) {
        String str = "take u forward";

        System.out.println(removeSpaces(str.toLowerCase()));
    }
    private static StringBuilder removeSpaces(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            //If vowel then skip else append in new string
            if(str.charAt(i) == ' '){
                continue;
            }
            newString.append(str.charAt(i));
        }
        System.out.println();
        return newString;

    }

}