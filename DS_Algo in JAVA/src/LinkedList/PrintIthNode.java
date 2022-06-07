package LinkedList;
import java.util.*;
public class PrintIthNode {
    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null,tail = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<Integer>(data);
            if(head==null){
                // head should point to the current node.
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
    public static Node<Integer> Insert(Node<Integer> head,int data,int pos){
        Node<Integer> NodeToBeInserted = new Node<Integer>(data);
        if(pos==0){
            NodeToBeInserted.next = head;
            return NodeToBeInserted;
        }else{
            int count = 0;
            Node<Integer> prev = head;
            while(count<pos-1 && prev!=null){
                count++;
                prev = prev.next;
            }
            if(prev!=null){
                NodeToBeInserted.next = prev.next;
                prev.next = NodeToBeInserted;
            }
        }
        return head;
    }
    public static void IthNode(Node<Integer> head,int i){
        Node<Integer> current = head;
        int count = 0;
        while(current!=null){
            if(count==i){
                System.out.println(current.data);
            }
            count++;
            current = current.next;
        }
    }
    public static void print(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        //Scanner sc = new Scanner(System.in);
        //int i = sc.nextInt();
        print(head);
        //IthNode(head,i);
        head = Insert(head,8,0);
        print(head);
    }
}
