
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {
        // Creating a TreeMap (Natural Sorting on Keys)
        TreeMap<String, Integer> studentAges = new TreeMap<>();

        studentAges.put("Smith", 30);
        studentAges.put("Anderson", 31);
        studentAges.put("Lewis", 29);
        studentAges.put("Cook", 29);

        // This will print keys sorted alphabetically!
        System.out.println("Sorted Map: " + studentAges);

        // Boundary Methods
        System.out.println("First Key: " + studentAges.firstKey()); // Output: Anderson
        System.out.println("Last Key: " + studentAges.lastKey());   // Output: Smith
    }
}
