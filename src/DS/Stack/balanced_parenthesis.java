package DS.Stack;

import java.util.Stack;

public class balanced_parenthesis {
    public static void main(String[] args) {
        String inputParenthesis = "()[{()]";
        if(isValid(inputParenthesis))
            System.out.println("Valid");
        else
            System.out.println("Invalid");

    }
    private static boolean isValid(String input){
        Stack<Character> stack = new Stack<>();

        for (Character inputCharacter : input.toCharArray()) {
            if(inputCharacter == '(' || inputCharacter == '{' || inputCharacter == '[')
                stack.push(inputCharacter);
            else{
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(top == '(' && inputCharacter == ')' || top == '{' && inputCharacter == '}' || top == '[' && inputCharacter == ']') continue;
                return false;
            }
        }
        return stack.isEmpty();

    }
}