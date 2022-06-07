package LinkedList;
import java.util.*;
public class InsertRecursive {


    public  static Node<Integer> takeInputs(){
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
    public static Node<Integer> Insert(Node<Integer> head,int elem,int pos){
        if(head==null && pos>0){
            return head;
        }
        Node<Integer> NodeToBeInserted = new Node<>(elem);
        if(pos==0){
            NodeToBeInserted.next = head;
            return NodeToBeInserted;
        }else{
            Node<Integer> smallerHead = Insert(head.next,elem,pos-1);
            head.next = smallerHead;
        }
        return head;
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        printLL(head);
        Scanner sc = new Scanner(System.in);
        int pos = sc.nextInt();
        int elem = sc.nextInt();
        head = Insert(head,elem,pos);
        printLL(head);

    }
}
