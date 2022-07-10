package DS.Sting;

public class C10_capitalize {
    public static void main(String[] args) {
        String str = "take u forward is awesome";

        System.out.println(capitalizeFirstAndLast(str));
    }

    //Capital:
    // First & last index
    //  char before space and after space
    private static String capitalizeFirstAndLast(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < str.length(); i++) {

            if (i == 0 || i == str.length() - 1)
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            else if (str.charAt(i) == ' ') //capital char before & after
            {
                sb.setCharAt(i - 1, Character.toUpperCase(sb.charAt(i - 1)));
                sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
            }
        }
        return sb.toString();
    }
}