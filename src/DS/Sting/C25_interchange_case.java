package DS.Sting;

public class C25_interchange_case {
    public static void main(String[] args) {
        String str = "TAKE U FORWARD is aWESOME";
        System.out.println(changeCase(str));
    }

    public static String changeCase(String str){
        StringBuilder result = new StringBuilder();

        for(char ch : str.toCharArray()){
            if(Character.isLetter(ch) && Character.isLowerCase(ch))
                result.append(Character.toUpperCase(ch));
            else if(Character.isLetter(ch) && Character.isUpperCase(ch))
                result.append(Character.toLowerCase(ch));
            else
                result.append(ch);
        }

        return result.toString();
    }
}