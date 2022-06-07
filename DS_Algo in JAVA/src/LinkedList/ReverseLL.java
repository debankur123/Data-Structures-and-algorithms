package LinkedList;

import java.util.Scanner;

public class ReverseLL {
    public static Node<Integer> reverse(Node<Integer> head){
        Node<Integer> prev = null,current = head;
        while(current!=null) {
            Node<Integer> nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;

        }
        head = prev;
        return head;
    }

    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data  = s.nextInt();
        Node<Integer> head = null,tail = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<>(data);
            if(head==null){
                head = currentNode;
                tail = currentNode;
            }else{
                tail.next = currentNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static void printLL(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        head = ReverseLL.reverse(head);
        printLL(head);
    }


}
