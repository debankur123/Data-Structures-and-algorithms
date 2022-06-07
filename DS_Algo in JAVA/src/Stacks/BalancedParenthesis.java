package Stacks;
import java.util.Stack;

public class BalancedParenthesis {

    public static boolean isBalanced(String expr){
        Stack<Character> st = new Stack<>();
        for(int i=0;i<expr.length();i++){
            char x = expr.charAt(i);
            if(x =='(' || x =='{' || x =='['){
                st.push(x);
                continue;
            }
            if(st.isEmpty()){
                return false;
            }
            char check;
            switch (x){
                case ')':
                    check = st.pop();
                    if(check =='{' || check =='['){
                        return false;
                    }
                    break;
                case '}':
                    check = st.pop();
                    if(check =='(' || check =='['){
                        return false;
                    }
                    break;
                case ']':
                    check = st.pop();
                    if(check =='(' || check =='{'){
                        return false;
                    }
                    break;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        String expr = "([{}])}";
        if (isBalanced(expr)){
            System.out.println("Brackets are balanced");
        }else{
            System.out.println("Brackets are not balanced");
        }
    }
}
