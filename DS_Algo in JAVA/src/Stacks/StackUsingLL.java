package Stacks;
import LinkedList.Node;

public class StackUsingLL<T> {
    private Node<T> head;
    int size;

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public void push( T elem){
        Node<T> newNode = new Node<T>(elem);
        newNode.next = head; // Here insertion is at the beginning of the linked list;
        head = newNode;
        size++;
    }
    public T top() throws StackEmptyException {
        if(head==null){
            throw new StackEmptyException();
        }else{
            return head.data;
        }
    }
    public T pop() throws StackEmptyException {
        if(head==null){
            throw new StackEmptyException();
        }else{
            T temp = head.data;
            head = head.next; // delete's the head of the linked list
            size--;
            return temp;
        }
    }
}
