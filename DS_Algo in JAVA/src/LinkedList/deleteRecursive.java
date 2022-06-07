package LinkedList;
import java.util.*;

public class deleteRecursive {
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

    public static void printLL(Node<Integer> head){
        Node<Integer> current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current =current.next;
        }
        System.out.println();
    }

    public static Node<Integer> delete(Node<Integer> head,int pos){
        if(head==null){
            return head;
        }
        if(pos==0){
            head = head.next;
            return head;
        }
        Node<Integer> smallerHead = delete(head.next,pos-1);
        head.next = smallerHead;
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        printLL(head);
        Scanner s = new Scanner(System.in);
        int pos = s.nextInt();
        head = delete(head,pos);
        printLL(head);
    }
}
