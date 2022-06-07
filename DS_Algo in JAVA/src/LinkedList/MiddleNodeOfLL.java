package LinkedList;
import java.util.*;
public class MiddleNodeOfLL {
    public  static Node<Integer> middle(Node<Integer> head){
        Node<Integer> slow = head;
        Node<Integer> fast = head;
        int len = lengthLL(head);
        if(len%2==0){
            while(fast.next!=null && fast.next.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }else if(len%2!=0){
            while(fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return slow;
    }

    public static Node<Integer> midpoint(Node<Integer> head){
        Node<Integer> slow = head,fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    public static int lengthLL(Node<Integer> head){
        Node<Integer> current = head;
        int i = 0;
        while(current!=null){
            i++;
            current = current.next;
        }
        return i;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        Node<Integer> slow = midpoint(head);
        System.out.println("The middle node of the linked list is : " + " " + slow.data);
    }
}
