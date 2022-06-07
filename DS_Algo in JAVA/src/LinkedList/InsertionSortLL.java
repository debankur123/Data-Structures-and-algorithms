package LinkedList;

import java.util.Scanner;

public class InsertionSortLL {
    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null,tail = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<>(data);
            if(head==null){
                head = currentNode;
                tail = currentNode;
            }
            else{
                tail.next = currentNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;
    }

    public static Node<Integer> sortLL(Node<Integer> head){
        Node<Integer> dummy = new Node<>(1000000);
        Node<Integer> current = head;
        while(current!=null){
            Node<Integer> nxt = current.next;
            Node<Integer> temp = dummy;
            while(temp.next!=null && (temp.next.data<head.data)){
                temp = temp.next;
            }
            current.next = temp.next;
            temp.next = current;
            current = nxt;
        }
        return dummy.next;
    }
    public static void printLL(Node<Integer> head){
        Node<Integer> current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test>0){
            Node<Integer> head = takeInputs();
            head = sortLL(head);
            printLL(head);

            test--;
        }


    }

}
