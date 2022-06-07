package LinkedList;

import java.util.Scanner;

public class KReverse {

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

    public static void printLL(Node<Integer> head){
        Node<Integer> current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node<Integer> kReverse(Node<Integer> head, int k){
        if(head==null || k<=1){
            return head;
        }
        Node<Integer> current = head;
        Node<Integer> nxt = null;
        Node<Integer> prev = null;

        int count = 0;
        while(count<k && current!=null){
            nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
            count++;
        }
        if(nxt!=null){
            head.next = kReverse(nxt,k);
        }
        return prev;
    }

    public static Node<Integer> kReverse2(Node<Integer> head, int k) {
 		//Your code goes here
         if(head==null || k==0){
             return head;
         }
         Node<Integer> dummy = new Node<>(0);
         dummy.next = head;

         Node<Integer> current=dummy,prev = dummy,nxt=dummy;
         int count =0;
         while(current.next!=null){
             current = current.next;
             count++;
         }
         while(count>=k){  // take a linked list of 1-2-3-4-5-6-7-8
             current = prev.next;  // current = 1
             nxt = current.next;  // nxt = 2
             for(int i=1;i<k;i++){
                 current.next = nxt.next; // current.next = 3
                 nxt.next = prev.next;    // nxt.next = 1
                 prev.next = nxt;         // prev.next = 3
                 nxt = current.next;      // nxt = 4

             }
             prev = current;              // 2
             count-=k;
         }
         return dummy.next;               // 3
     }




        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        while(test_case>0){
            Node<Integer> head = takeInputs();
            int k = sc.nextInt();
            head = kReverse(head,k);
            //head = kReverse2(head,k);
            printLL(head);
            test_case--;
        }

    }
}
