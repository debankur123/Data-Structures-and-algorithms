package Stacks;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {
        //StackUingArrays st = new StackUingArrays(1);
        StackUsingLL<Integer> st = new StackUsingLL<>();

        int arr[] = {5,6,7,1,4};

        for(int i=0;i<arr.length;i++){
            st.push(arr[i]);
        }
        while (! st.isEmpty()){
            System.out.println(st.pop());
        }
        //System.out.println(st.size());



//        st.push(10);
//        System.out.println(st.top());
//        st.pop();
//        System.out.println(st.isEmpty());
//        st.size();

    }
}
