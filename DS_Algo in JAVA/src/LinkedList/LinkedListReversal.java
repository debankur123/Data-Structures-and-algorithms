package LinkedList;
import java.util.*;

public class LinkedListReversal {
    public  static DoubleNode  reverseLLRecursiveBetter(Node<Integer> head){
        DoubleNode ans;
        if(head == null || head.next==null){
            ans = new DoubleNode();
            ans.head = head;
            ans.tail = head;
            return ans;
        }
        //This DoubleNode has both tail and head of the reversed linked list
        DoubleNode smallAns = reverseLLRecursiveBetter(head.next);
        smallAns.tail.next = head;
        head.next = null;
        ans = new DoubleNode();
        ans.head = smallAns.head;
        ans.tail = head;
        return ans;

    }

    public static Node<Integer> reverseLLBest(Node<Integer> head){
        if(head==null || head.next==null){
            return head;
        }
        Node<Integer> smallAns = reverseLLBest(head.next);
        Node<Integer> reversedTail = head.next;
        reversedTail.next = head;
        head.next = null;
        return smallAns;
    }

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
        head = reverseLLBest(head);
        //DoubleNode ans = reverseLLRecursiveBetter(head);
        printLL(head);
    }
}
