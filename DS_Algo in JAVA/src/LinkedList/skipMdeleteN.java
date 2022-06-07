package LinkedList;

import java.util.Scanner;

public class skipMdeleteN {

    public static Node<Integer> takeInputs(){
        Scanner s = new Scanner(System.in);
        int data  = s.nextInt();
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

    public static Node<Integer> deleteNafterM(Node<Integer> head,int m,int n){
        if(m==0){
            return null;
        }
        if(n==0){
            return head;
        }
        Node<Integer> original = head;
        Node<Integer> temp1 = head,temp2  =head;
        while(head!=null){
            temp1 = head;
            for(int i=1;i<m && temp1!=null;i++){
                temp1 = temp1.next;
            }
            if(temp1!=null){
                temp2 = temp1.next;
            }
            for(int i=1;i<n && temp2!=null;i++){
                temp2 = temp2.next;
            }
            if(temp2!=null){
                temp2 = temp2.next;
            }
            // Connect temp1 and temp2 after deleting the n nodes
            if(temp1!=null){
                temp1.next = temp2;
            }
            head = temp2;
        }
        return original;
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
        Scanner s  = new Scanner(System.in);
        int test = s.nextInt();
        while(test>0){
            Node<Integer> head = takeInputs();
            int m = s.nextInt();
            int n = s.nextInt();
            head = deleteNafterM(head,m,n);
            printLL(head);
            test--;
        }

    }
}
