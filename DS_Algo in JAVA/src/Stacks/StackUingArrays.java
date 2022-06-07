package Stacks;

public class StackUingArrays {
    private int data[];
    private int topIndex; // This is the top most element of the stack

    public StackUingArrays(){
        data  = new int[10];
        topIndex = -1;
    }

    public StackUingArrays(int size){
        data = new int[size];
        topIndex = -1;
    }
    // O(1)
    public int size(){

        return topIndex+1;
    }
    // O(1)
    public void push(int elem) throws StackFullException{
        // If stack is full
        if(topIndex==data.length-1){
            doubleCapacity();
        }
        // topIndex++;
        data[++topIndex] = elem;
    }
    //O(n)
    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2*temp.length];
        for(int i=0;i< temp.length;i++){
            data[i]  =temp[i];
        }
    }

    // O(1)
    public int top() throws StackEmptyException {
        if(topIndex==-1){
            throw new StackEmptyException();
        }

        return data[topIndex];
    }
    // O(1)
    public int pop() throws StackEmptyException{
        if(topIndex==-1){
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }
    // O(1)
    public boolean isEmpty(){
        if(topIndex==-1){
            return true;
        }else{
            return false;
            // or we can simply write : return topIndex==-1;
        }
    }
}
