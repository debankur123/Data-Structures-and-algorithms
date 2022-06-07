package LinkedList;
import java.util.*;
public class DeleteNode {
    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null,tail = null;
        while(data!=-1){
            Node<Integer> currentNode = new Node<Integer>(data);
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

    public static Node<Integer> delete(Node<Integer> head,int pos){
        //Node<Integer> NodeToBeDeleted = new Node<Integer>(data);
        if(head==null){
            return null;
        }
        if(pos==0){
            head = head.next;
            return head;
        }else{
            int count = 0;
            Node<Integer> prev = head;
            while(count<pos-1 && prev!=null && prev.next!=null ){
                count++;
                prev = prev.next;
            }if(prev!=null && prev.next!=null){
                prev.next = prev.next.next;
            }
        }
        return head;
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
        print(head);
        //IthNode(head,i);
        head = delete(head,3);
        print(head);
    }
}
