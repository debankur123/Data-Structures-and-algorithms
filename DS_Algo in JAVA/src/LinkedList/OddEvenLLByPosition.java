// Leetcode Medium :

// Given the head of a singly linked list, group all the nodes with odd indices together
// followed by the nodes with even indices, and return the reordered list.
//
// The first node is considered odd, and the second node is even, and so on.
//
// Note that the relative order inside both the even and odd groups should
// remain as it was in the input.
// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

// For example Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]


package LinkedList;

import java.util.Scanner;

public class OddEvenLLByPosition {

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
    public static  Node oddEvenList(Node head) {
        if(head==null){
            return head;
        }
        Node oddHead = head;
        Node evenHead = head.next;
        Node even = evenHead;

        while(evenHead!=null && evenHead.next!=null){
            oddHead.next = evenHead.next;
            oddHead = oddHead.next;
            evenHead.next = oddHead.next;
            evenHead = evenHead.next;
        }
        oddHead.next = even;

        return head;
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
            head = oddEvenList(head);
            printll(head);

            test_case--;
        }


    }


}
