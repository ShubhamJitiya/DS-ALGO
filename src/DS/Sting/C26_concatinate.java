package DS.Sting;

public class C26_concatinate {
    public static void main(String[] args) {
        String str1 = "Fix";
        String str2 = " Bug";

        System.out.println(str1+str2);
        System.out.println(str1.concat(str2));

        StringBuilder sb = new StringBuilder(str1);
        sb.append(str2);
        System.out.println(sb);

    }
}