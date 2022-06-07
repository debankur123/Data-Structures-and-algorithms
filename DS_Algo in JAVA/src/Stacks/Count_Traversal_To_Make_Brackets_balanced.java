package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class Count_Traversal_To_Make_Brackets_balanced {
    public static int countTraversal(String str) {
        int len = str.length();
        if (len % 2 != 0) {
            return -1;
        }
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c == '}' && !st.isEmpty()) {
                if (st.peek() == '{') {
                    st.pop();
                } else {
                    st.push(c);
                }
            } else if (c == '}' && st.size() == 0) {
                st.push(c);
            } else {
                st.push(c);
            }
        }
        int reduced_len = st.size();
        int count = 0;
        while (!st.isEmpty() && st.peek() == '{') {
            st.pop();
            count++;
        }
        return (reduced_len / 2 + count % 2);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = countTraversal(str);
        System.out.println(result);

    }
}
