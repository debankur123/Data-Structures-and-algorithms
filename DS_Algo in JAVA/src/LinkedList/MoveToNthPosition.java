package LinkedList;
import java.util.Scanner;

//import static javax.swing.text.html.HTML.Attribute.N;

public class MoveToNthPosition {
    //1-2-3-4-5-6
    // if n = 3 we will go to the third element and from there we will
    // join the elements at the front.
    // then the linked list would look like 3-4-5-1-2
    // we will start from len-n and from there we will break
    // connection and append to first
    public static int LengthOfLL(Node<Integer> head){
       int i=0;
       Node<Integer> current = head;
       while(current!=null){
           i++;
           current = current.next;
       }
       return i;
    }
    public static Node<Integer> MoveBynPosition(Node<Integer> head,int n){
        // suppose N = 3;
        int k = LengthOfLL(head);
        if(k-n<=0 || n<=0){
            return head;
        }
        int count = 0;
        Node<Integer> temp = head;
        while (temp.next!=null){
            temp = temp.next;
        }
        Node<Integer> temp1 = temp;
        temp = head;
        while (count<k-n-1){
            count++;
            temp = temp.next;
        }
        Node<Integer> temp2 = temp.next;
        temp.next = null;
        temp1.next = head;
        return temp2;
    }

    public static void printLL(Node<Integer> head){
        Node<Integer> temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node<Integer> takeInputs() {
        Scanner s = new Scanner(System.in);
        int data = s.nextInt();
        Node<Integer> head = null, tail = null;
        while (data != -1) {
            Node<Integer> currentNode = new Node<Integer>(data);
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
    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        head = MoveBynPosition(head,n);
        printLL(head);

    }
}
