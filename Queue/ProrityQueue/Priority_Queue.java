
import java.io.Serializable;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Priority_Queue implements Serializable {

    public static void main(String[] args) {
        Priority_Queue pqObject = new Priority_Queue();

        //Declaration:
        PriorityQueue<Integer> pqI = new PriorityQueue();
        PriorityQueue<String> pqS = new PriorityQueue();

        //Add method-->Adds the values into the heap-->Heapifies it-->then stores it.
        pqI.add(1);
        pqI.add(2);
        pqI.add(3);
        pqI.add(4);
        pqI.add(5);
        pqI.add(0);
        pqS.add("Shanmukh");
        pqS.add("Sai");

        System.out.println("Elements are : " + pqI);   //can directly print entire queue
        System.out.println("Elements are : " + pqS);   //can directly print entire queue

        //Peek method
        System.out.println("Peek element is : " + pqI.peek());
        System.out.println("Peek element is : " + pqS.peek());

        //Remove method
        //boolean -> not a correct way to remove last ele
        System.out.println("The ele in the top priority gets removed i.e : " + pqI.remove());


        //Iterating using Iterator Interface as it is implemented by PriorityQueue.
        Iterator<Integer> i = pqI.iterator();
        while(i.hasNext()){
            System.out.print(i.next()+" ");
        } 

    }
}
