package Stacks;

import java.util.Stack;

public class StackCollection {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        int arr[] = {5,6,7,1,4};

        for(int elem: arr){
            st.push(elem);
        }
        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }

    }
}
