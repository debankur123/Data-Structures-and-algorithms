package LinkedList;

import java.util.Scanner;

public class SearchNodeLL {
    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
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

    public static int search(Node<Integer> head,int elem){
        if(head==null){
            return -1;
        }
        if(head.data==elem){
            return 0;
        }
        int smallAns = search(head.next,elem);
        if(smallAns==-1){
            return -1;
        }else{
            return 1+smallAns;
        }
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        Scanner s = new Scanner(System.in);
        int elem = s.nextInt();
        int result = search(head,elem);
        System.out.print("The element is present at index :  " + result);
    }
}
