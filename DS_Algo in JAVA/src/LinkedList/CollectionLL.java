package LinkedList;

import java.util.LinkedList;

public class CollectionLL {
    public static void main(String[] args) {


        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40); // add elements to the linked list from last
        list.add(2,100); // insert elements at aiven position
        list.addFirst(200); // add elements at the beginning of the list
        list.set(3,50); // sets elements at the given position
        list.remove();

        System.out.println(list.get(2)); // fetch elements at the given index
        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i) + " "); // to print the linked list
        }
    }
}
