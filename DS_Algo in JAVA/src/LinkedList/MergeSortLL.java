package LinkedList;
import java.util.*;
public class MergeSortLL {
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

    public static Node<Integer> midpoint(Node<Integer> head){
        Node<Integer> slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> merge(Node<Integer> head1,Node<Integer> head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        Node<Integer> t1 = head1,t2 = head2,head = null,tail = null;

        if(t1.data<=t2.data){
            head = t1;
            tail = t1;
            t1 = t1.next;
        }else{
            head = t2;
            tail = t2;
            t2 = t2.next;
        }
        while(t1!=null && t2!=null){
            if(t1.data<=t2.data){
                tail.next = t1;
                tail = t1;
                t1 = t1.next;
            }else{
                tail.next = t2;
                tail  = t2;
                t2 = t2.next;
            }
        }
        if(t1!=null){
            tail.next = t1;
        }else{
            tail.next = t2;
        }
        return head;
    }

    public static Node<Integer> mergeSort(Node<Integer> head){
        if(head==null || head.next!=null){
            return head;
        }
        Node<Integer> mid = midpoint(head);
        Node<Integer> part1_head = head;
        Node<Integer> part2_head = mid.next;

        mid.next = null;
        part1_head = mergeSort(part1_head);
        part2_head = mergeSort(part2_head);

        Node<Integer> finalHead = merge(part1_head,part2_head);
        return finalHead;
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
        Node<Integer> head = takeInputs();
        Node<Integer> finalHead = mergeSort(head);
        printLL(finalHead);
    }
}
