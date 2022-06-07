package LinkedList;

import java.util.Scanner;

public class RemoveDuplicates {
    public static Node<Integer> duplicates(Node<Integer> head){
        Node<Integer> ptr1 = null,ptr2 = null;
        ptr1 = head;
        while(ptr1!=null && ptr1.next!=null){
            ptr2 = ptr1;
            while(ptr2.next!=null){
                if(ptr1.data.equals(ptr2.next.data)){
                    ptr2.next = ptr2.next.next;
                }
                else{
                    //ptr2 = ptr2.next;
                    break;
                }
            }
            ptr1 = ptr1.next;
        }
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
        head = RemoveDuplicates.duplicates(head);
        printLL(head);
    }
}
