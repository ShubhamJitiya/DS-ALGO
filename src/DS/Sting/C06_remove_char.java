package DS.Sting;

public class C06_remove_char {
    public static void main(String[] args) {
        //A - Z - 65 to 90
        //a - z - 97 to 122

        String str = "take12% *&u ^$#forward";
        System.out.println(removeExceptAlphabets(str));
    }

    private static String removeExceptAlphabets(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 65 && str.charAt(i) <=90 || str.charAt(i) >= 97 && str.charAt(i) <=122){
                newString.append(str.charAt(i));
            }

        }
        return newString.toString();
    }
}