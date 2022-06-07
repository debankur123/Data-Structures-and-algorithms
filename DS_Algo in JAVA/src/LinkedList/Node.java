package LinkedList;

public class Node<T> {
    public T data;
    public Node<T> next;
    public Node(T data){
        this.data = data; // next = null we dont have to write this because its by default null
    }
}
