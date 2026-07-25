
import java.io.Serializable;
import java.util.Comparator;
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

        /*
        Remove method
        boolean -> not a correct way to remove last ele
        remove and poll both does same, but return diff values when queue is empty.
        remove --> java.util.NoSuchElementException
        poll --> null
         */
        System.out.println("The ele in the top priority gets removed i.e : " + pqI.remove());
        System.out.println("The ele in the top priority gets removed i.e : " + pqI.poll());

        //Iterating using Iterator Interface as it is implemented by PriorityQueue.
        Iterator<Integer> i = pqI.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }

        // Create a Max-Heap priority queue
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        pqMax.add(10);
        pqMax.add(5);
        pqMax.add(20);
        pqMax.add(15);
        System.out.println("Top element (max): " + pqMax.peek()); // 20

        // Polling (removing the top element)
        System.out.println("Removed element: " + pqMax.poll()); // 20
        System.out.println("Top element (after poll): " + pqMax.peek()); // 15
    }
}
