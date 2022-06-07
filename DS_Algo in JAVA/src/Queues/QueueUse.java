package Queues;

public class QueueUse {
    public static void main(String[] args) throws QueueEmptyException {
        //QueueUsingArrays q = new QueueUsingArrays(3);
        QueueUsingLL<Integer> q = new QueueUsingLL<>();
        int arr[] = {10,20,30,40,50};
        for(int elem: arr){
            q.enqueue(elem);
        }

        while(!q.isEmpty()){
            System.out.println(q.dequeue()); // This can be done using try catch also
        }
    }
}
