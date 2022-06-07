package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
    public static int[] takeInputs(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Element at :" + i+" "+"th index is : ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void reverse(Stack<Integer> st,Stack<Integer> helper){
        if(st.size()==0 || st.size()==1){
            return;
        }
        int temp = st.pop(); // getting the first element and storing it in temp
        reverse(st,helper); // recursive call on the rest of the element
        while(!st.isEmpty()){
            helper.push(st.pop());
        }
        st.push(temp);
        while(!helper.isEmpty()){
            st.push(helper.pop());
        }
    }

    public static void main(String[] args) {
        int[] arr = takeInputs();
        //int n = arr.length;
        Stack<Integer> st = new Stack<>();
        for(int elem: arr){
            st.push(elem);
        }
        Stack<Integer> helper = new Stack<>();
        ReverseStack.reverse(st,helper);
        while(!st.isEmpty()){
            //System.out.print(st.peek());
            System.out.print(st.pop() + " ");
        }


    }

}
