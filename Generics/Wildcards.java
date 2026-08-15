// Wildcards and the PECS Rule
// This is the classic implementation of PECS (Producer Extends, Consumer Super). We write a method that copies numbers from one list to another.

// The source list is producing data (we read from it), so we use ? extends Number.
// The destination list is consuming data (we write to it), so we use ? super Number.
import java.util.*;

public class Wildcards {

    public static void copyNumbers(List<? extends Number> srcLs, List<? super Number> destLs) {
        for (Number number : srcLs) {
            destLs.add(number); // Writing to Consumer
        }
    }

    public static void main(String[] args) {
        /* 
        1. Setup our Source (Producer)--> We can pass a List of Integers because Integer extends Number
        As, Number is an abstract class in Java located in the java.lang package.
         */
        List<Integer> intSource = Arrays.asList(1, 2, 3);

        // 2. Setup our Destination (Consumer)
        // We can pass a List of Objects because Object is a superclass of Number
        List<Object> objectDest = new ArrayList<>();

        // 3. Execute the copy
        copyNumbers(intSource, objectDest);

        System.out.println("Copied list: " + objectDest);

        /*
        WHY THIS IS SAFE:
        By using <? super Number> for the destination, Java guarantees the list 
        is capable of holding *at least* a Number (like Object or Number itself), 
        making it perfectly safe to add Integers or Doubles into it.
         */
    }
}
