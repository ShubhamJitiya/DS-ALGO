package DS.Sting;

public class C08_remove_brackets {
    public static void main(String[] args) {
        String str = "(((a-b))+c)";
        System.out.println(removeBrackets(str));
    }

    private static String removeBrackets(String str) {
        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != '(' && str.charAt(i) != ')'){
                newString.append(str.charAt(i));
            }

        }
        return newString.toString();
    }
}