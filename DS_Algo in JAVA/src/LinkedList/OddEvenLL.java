package LinkedList;

import javax.print.attribute.IntegerSyntax;
import java.util.Scanner;

public class OddEvenLL {
    public static Node<Integer> takeInputs() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<>(data);
            if (head == null) {
                head = currentNode;
                tail = currentNode;
            } else {
                tail.next = currentNode;
                tail = tail.next;
            }
            data = s.nextInt();
        }
        return head;

    }

    public static Node<Integer> checkOddEven(Node<Integer> head){
        if(head==null && head.next==null){
            return head;
        }
        Node<Integer> dummyOdd = new Node<>(-1);
        Node<Integer> dummyEven = new Node<>(-1);
         Node<Integer> oddTail = dummyOdd;
         Node<Integer> evenTail = dummyEven;

         Node<Integer> current = head;

         while(current!=null){
             if(current.data%2==0){
                 evenTail.next = current;
                 evenTail = evenTail.next;
             }else{
                 oddTail.next = current;
                 oddTail = oddTail.next;
             }
             current = current.next;
         }
         oddTail.next = dummyEven.next;
         evenTail.next = null;
         return dummyOdd.next;
    }

    public static void printll(Node<Integer> head){
        Node<Integer> current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test_case = s.nextInt();
        while(test_case>0){
            Node<Integer> head = takeInputs();
            head = checkOddEven(head);
            printll(head);
            test_case--;
        }




    }
}
