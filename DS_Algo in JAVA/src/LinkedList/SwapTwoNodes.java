package LinkedList;

import java.util.Scanner;

public class SwapTwoNodes {
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

    public static Node<Integer> swapNodes(Node<Integer> head,int i,int j) {
        if (i == j) {
            return head;
        }

        Node<Integer> currentNode = head, prev = null;
        Node<Integer> firstNode = null, secondNode = null, firstNodePrev = null, secondNodePrev = null;

        int pos = 0;

        while (currentNode != null) {

            if (pos == i) {
                firstNodePrev = prev;
                firstNode = currentNode;
            } else if (pos == j) {
                secondNodePrev = prev;
                secondNode = currentNode;
            }

            prev = currentNode;
            currentNode = currentNode.next;
            pos += 1;

        }

        if (firstNodePrev != null) {
            firstNodePrev.next = secondNode;
        } else {
            head = secondNode;
        }

        if (secondNodePrev != null) {
            secondNodePrev.next = firstNode;
        } else {
            head = firstNode;
        }

        Node<Integer> currentfirstNode = secondNode.next;
        secondNode.next = firstNode.next;
        firstNode.next = currentfirstNode;

        return head;
    }

    public static  void printLL(Node<Integer> head) {
        Node<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;

        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        while(test>0){
            Node<Integer> head = takeInputs();
            int i = s.nextInt();
            int j = s.nextInt();
            head = swapNodes(head,i,j);
            printLL(head);

            test--;
        }

    }

}
