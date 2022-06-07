package LinkedList;

import java.util.Scanner;

public class BubbleSortLL {

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

    public static Node<Integer> sort(Node<Integer> head){
        Node<Integer> i = head, j = null;
        while(i!=null){
            j = head;
            while(j.next!=null){
                if(j.data>j.next.data){
                    swap(j,j.next);
                }
                j = j.next;
            }
            i = i.next;
        }
        return  head;
    }

    public static void swap(Node<Integer> a,Node<Integer> b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    public static void printLL(Node<Integer> head){
        Node<Integer> current = head;
        while(current!=null){
            System.out.print(current.data + " ");
            current =current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node<Integer> head = takeInputs();
        head = sort(head);
        printLL(head);
    }
}
