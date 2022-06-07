package LinkedList;
import java.util.*;
public class MergeTwoSortedLL {
    public static Node<Integer> merge(Node<Integer> head1,Node<Integer> head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }

        Node<Integer> t1 = head1,t2 = head2;
        Node<Integer> head = null,tail = null;

        // Take an example of 1->3->5->6    here head is pointing to 1 and tail also and t1 also
        // and second one is 2->4->8->9->10->11   here t2 is pointing to head

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
                tail = t2;
                t2 = t2.next;
            }

        }
        // one list is over

        // This is for the remaining list i.e if any of the list still contains data
        if(t1!=null){
            tail.next = t1;
        }else{
            tail.next = t2;
        }
        return head;
    }

    public static Node<Integer> takeInputs2(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head1 = null,tail1 = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<>(data);
            if(head1==null){
                head1 = currentNode;
                tail1 = currentNode;
            }
            else{
                tail1.next = currentNode;
                tail1 = tail1.next;
            }
            data = s.nextInt();
        }
        return head1;
    }
    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head2 = null,tail2 = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<>(data);
            if(head2==null){
                head2 = currentNode;
                tail2= currentNode;
            }
            else{
                tail2.next = currentNode;
                tail2 = tail2.next;
            }
            data = s.nextInt();
        }
        return head2;
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
        Node<Integer> head1 = takeInputs();
        Node<Integer> head2 = takeInputs2();
        Node<Integer> head = merge(head1,head2);
        printLL(head);
    }


}
