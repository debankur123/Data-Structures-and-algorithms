package LinkedList;

import java.util.Scanner;

public class PrintReverseLL_Recursive {
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

    public static void printRecursive(Node<Integer> head){
        if(head==null){
            return;
        }
        printRecursive(head.next);
        System.out.print(head.data + " ");
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        printRecursive(head);
    }
}
