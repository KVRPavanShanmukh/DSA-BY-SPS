
import java.util.*;

public class HashMapMethods {

    public static void main(String[] args) {
        int a[] = {1, 2, 2, 2, 2, 2, 23, 4, 4, 4, 4, 52, 6, 47, 85, 96, 110, 311, 12, 12, 130};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : a) {
            hm.put(i, hm.getOrDefault(i, 0) + 1);
        }

        System.out.println(hm.get(2)); // gives the freq of a given key.
        System.out.println(hm.isEmpty()); // tells whether the map is empty.
        System.out.println(hm.size()); // gives the size of the map.

        System.out.println(hm.remove(4, 1)); // removes the specified key and its value.
        System.out.println(hm.remove(5)); // removes the specified key completely.

        Set<Map.Entry<Integer, Integer>> es = hm.entrySet();
        System.out.println("Entry Set: " + es);

        Set<Integer> hs = hm.keySet();
        System.out.println("KeySet : " + hs);

        System.out.println(hm.containsKey(4)); // checks if a key exist
        System.out.println(hm.containsValue(5)); // checks if a value exist.
        // here the above containsValue returns true as 2 ahs freq of 5.

        hm.clear(); //clears the hm by removing all the elements from it.
        System.out.println(hm.size()); //to verify the size.

        System.out.println("ContainsValue YES / NO : " + hm.containsValue(2));

        Collection<Integer> cl = hm.values();
        System.out.println("Values in HM : " + cl); //shows no o/p as hm was cleared!!
    }
}
