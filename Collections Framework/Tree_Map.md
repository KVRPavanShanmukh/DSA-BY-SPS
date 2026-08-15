A **`TreeMap`** is a specialized concrete implementation of the `Map` interface in Java designed to store key-value pairs in a strictly **sorted order**. Under the hood, it is implemented as a **Red-Black Balanced Binary Search Tree (BST)**. 

Unlike a standard `HashMap` which stores elements in an unpredictable, random order, a `TreeMap` automatically keeps its keys sorted in either their **natural order** (using the `Comparable` interface) or through a **custom order** (using a `Comparator` passed to its constructor).

---

### **When to Use a `TreeMap`**
You should choose a `TreeMap` over other map implementations when:
*   **Sorted Traversals:** You need to traverse or display your keys sequentially in a sorted order.
*   **Range-Based Queries:** You frequently need to retrieve subsets of data (e.g., "give me all records where keys are between 'A' and 'M'").
*   **Closest Match Queries:** You need to find "nearest neighbor" keys (such as finding the closest key greater than or equal to a target value).
*   **Dynamic Sorting Guarantee:** You want to guarantee that keys remain sorted even as you dynamically add or remove elements.

*If you do not require sorted keys, you should default to a standard `HashMap`, as it offers more efficient constant-time performance (\\(O(1)\\)) for basic updates and lookups.*

---

### **Performance Complexity**
Because a `TreeMap` relies on a balanced Red-Black tree structure, its performance characteristics are logarithmic rather than constant:

| Operation | Time Complexity | Reason |
| :--- | :--- | :--- |
| **Search (`get`)** | **\\(O(\log n)\\)** | Traverses down a balanced tree of height \\(\log n\\). |
| **Insertion (`put`)** | **\\(O(\log n)\\)** | Inserts a node and performs \\(O(1)\\) pointer rotations or color flips to maintain perfect black balance. |
| **Deletion (`remove`)** | **\\(O(\log n)\\)** | Locates the node, extracts it, and repairs the balanced tree height in logarithmic time. |

---

### **Key Specialized Methods**
Since `TreeMap` implements both the **`SortedMap`** and **`NavigableMap`** interfaces, it provides a unique set of powerful, order-sensitive methods:

#### **1. Boundary Methods (SortedMap)**
*   **`firstKey()`**: Returns the smallest key currently in the map.
*   **`lastKey()`**: Returns the largest key currently in the map.
*   **`headMap(toKey)`**: Returns a view of the portion of the map whose keys are strictly **less than** `toKey`.
*   **`tailMap(fromKey)`**: Returns a view of the portion of the map whose keys are **greater than or equal to** `fromKey`.

#### **2. Closest-Match Navigation Methods (NavigableMap)**
*   **`lowerKey(key)`**: Returns the largest key strictly **less than** the given key.
*   **`floorKey(key)`**: Returns the largest key **less than or equal to** the given key.
*   **`ceilingKey(key)`**: Returns the smallest key **greater than or equal to** the given key.
*   **`higherKey(key)`**: Returns the smallest key strictly **greater than** the given key.
*   **`pollFirstEntry()`** / **`pollLastEntry()`**: Removes and returns the first (smallest) or last (largest) key-value entry in the map.

---

### **Java Code Examples**

#### **Example 1: Basic Sorting**
By default, a `TreeMap` sorts keys in ascending order.
```java
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // Creating a TreeMap (Natural Sorting on Keys)
        TreeMap<String, Integer> studentAges = new TreeMap<>();
        
        studentAges.put("Smith", 30);
        studentAges.put("Anderson", 31);
        studentAges.put("Lewis", 29);
        studentAges.put("Cook", 29);
        
        // This will print keys sorted alphabetically!
        // Output: {Anderson=31, Cook=29, Lewis=29, Smith=30}
        System.out.println("Sorted Map: " + studentAges); 
        
        // Boundary Methods
        System.out.println("First Key: " + studentAges.firstKey()); // Output: Anderson
        System.out.println("Last Key: " + studentAges.lastKey());   // Output: Smith
    }
}
```

#### **Example 2: Navigable and Range Queries**
```java
TreeMap<Integer, String> grades = new TreeMap<>();
grades.put(60, "D");
grades.put(70, "C");
grades.put(80, "B");
grades.put(90, "A");

// Closest Matches
System.out.println("Ceiling for score 75: " + grades.ceilingKey(75)); // Output: 80 (Smallest key >= 75)
System.out.println("Floor for score 75: " + grades.floorKey(75));     // Output: 70 (Largest key <= 75)

// Subsets
System.out.println("Keys strictly below 80: " + grades.headMap(80)); // Output: {60=D, 70=C}
```

#### **Example 3: Custom Ordering with a Comparator**
To sort keys in reverse natural order (descending order), pass a custom `Comparator` to the constructor:
```java
// Create a TreeMap with a reverse-order comparator
TreeMap<String, Integer> reverseMap = new TreeMap<>(Collections.reverseOrder());

reverseMap.put("Smith", 30);
reverseMap.put("Anderson", 31);
reverseMap.put("Lewis", 29);

// Output: {Smith=30, Lewis=29, Anderson=31}
System.out.println("Descending Order: " + reverseMap);
```



In Java, **`headMap`** and **`tailMap`** are powerful operations defined in the **`SortedMap`** interface (and inherited by `NavigableMap`). They are primarily used with sorted map implementations like **`TreeMap`** to retrieve specific subsets of your sorted data based on key boundaries.

---

### **1. `headMap(toKey)`**
The `headMap` method retrieves the **beginning portion** of the map.
*   **Logic:** It returns a view of the portion of the map whose keys are strictly **less than** the specified `toKey`.
*   **Endpoint Behavior:** By default, the specified `toKey` is **exclusive** (not included in the result).
*   **Example:** If your map contains numeric grades ``, calling `headMap(80)` will return entries for ``.

### **2. `tailMap(fromKey)`**
The `tailMap` method retrieves the **ending portion** of the map.
*   **Logic:** It returns a view of the portion of the map whose keys are **greater than or equal to** the specified `fromKey`.
*   **Endpoint Behavior:** By default, the specified `fromKey` is **inclusive** (included in the result).
*   **Example:** Using the same grades ``, calling `tailMap(80)` will return entries for ``.

---

### **3. The Concept of "Views" (Submaps)**
A critical detail regarding these methods is that they do not return a brand-new, independent map. Instead, they return a **submap view** of the original map. 
*   **Dynamic Synchronization:** Any modification made to the returned submap (such as adding or removing entries) will be directly reflected in the original map, and vice-versa.
*   **Boundary Enforcement:** The submap views enforce their key ranges. If you attempt to insert a key into a `headMap(80)` that is greater than or equal to `80`, Java will throw an `IllegalArgumentException`.

---

### **4. Inclusive/Exclusive Customization with `NavigableMap`**
If you are working with `NavigableMap` (which extends `SortedMap` and is also implemented by `TreeMap`), Java provides overloaded versions of these methods that allow you to explicitly configure whether boundaries are inclusive or exclusive using a boolean flag:
*   `headMap(toKey, boolean inclusive)`: Set to `true` to include the `toKey` in your subset.
*   `tailMap(fromKey, boolean inclusive)`: Set to `false` to exclude the `fromKey` from your subset.

---

### **5. Code Example**

Here is how you can use both methods to filter sorted student records dynamically:

```java
import java.util.TreeMap;
import java.util.SortedMap;

public class SubmapExample {
    public static void main(String[] args) {
        // Creating a TreeMap containing usernames and scores
        TreeMap<String, Integer> leaderboard = new TreeMap<>();
        leaderboard.put("Alice", 95);
        leaderboard.put("Charlie", 88);
        leaderboard.put("Bob", 92);
        leaderboard.put("David", 74);
        
        // Keys are sorted alphabetically: [Alice, Bob, Charlie, David]
        System.out.println("Full Leaderboard: " + leaderboard);

        // 1. headMap: Get all players alphabetically before "Charlie" (Exclusive)
        SortedMap<String, Integer> head = leaderboard.headMap("Charlie");
        System.out.println("Players before Charlie: " + head); 
        // Output: {Alice=95, Bob=92}

        // 2. tailMap: Get all players alphabetically starting from "Charlie" (Inclusive)
        SortedMap<String, Integer> tail = leaderboard.tailMap("Charlie");
        System.out.println("Players from Charlie onwards: " + tail); 
        // Output: {Charlie=88, David=74}

        // 3. Modifying the view affects the main map
        tail.remove("David");
        System.out.println("Leaderboard after removing from tail view: " + leaderboard);
        // Output: {Alice=95, Bob=92, Charlie=88}
    }
}
```




In Java, the **`TreeMap`** class implements the `Map` interface while extending `NavigableMap` and `SortedMap`. This inheritance structure gives it all standard map operations alongside powerful, order-based navigation and range-query methods.

The table below details the primary methods available in the `TreeMap` class, categorised by their function:

### **TreeMap Methods Directory**

| Category | Method | Description |
| :--- | :--- | :--- |
| **Sorted Map Boundaries** | **`firstKey()`** | Retrieves the first (lowest) key currently in this map. |
| | **`lastKey()`** | Finds the last (highest) key currently in this map. |
| | **`firstEntry()`** | Obtains the node mapping associated with the lowest key. |
| | **`lastEntry()`** | Returns the node mapping associated with the highest key. |
| | **`pollFirstEntry()`** | Removes and returns the entry associated with the lowest key. |
| | **`pollLastEntry()`** | Extracts and yields the entry associated with the highest key. |
| **Closest-Match Navigation** | **`lowerKey(K key)`** | Finds the greatest key strictly less than the specified key. |
| | **`floorKey(K key)`** | Locates the greatest key less than or equal to the specified key. |
| | **`ceilingKey(K key)`** | Retrieves the smallest key greater than or equal to the specified key. |
| | **`higherKey(K key)`** | Determines the smallest key strictly greater than the specified key. |
| | **`lowerEntry(K key)`** | Returns key-value mappings corresponding to the greatest key strictly less than `key`. |
| | **`floorEntry(K key)`** | Provides key-value mappings corresponding to the greatest key less than or equal to `key`. |
| | **`ceilingEntry(K key)`** | Yields key-value mappings corresponding to the smallest key greater than or equal to `key`. |
| | **`higherEntry(K key)`** | Gives key-value mappings corresponding to the smallest key strictly greater than `key`. |
| **Range Queries & Submaps** | **`headMap(K toKey)`** | Returns a view of the portion of the map whose keys are strictly less than `toKey`. |
| | **`headMap(K toKey, boolean inclusive)`** | Returns a view of keys less than `toKey`, with optional boundary inclusion. |
| | **`tailMap(K fromKey)`** | Returns a view of the portion of the map starting from `fromKey` (inclusive). |
| | **`tailMap(K fromKey, boolean inclusive)`** | Returns a view of keys starting from `fromKey`, with optional boundary inclusion. |
| | **`subMap(K fromKey, K toKey)`** | Returns a view of the map whose keys range from `fromKey` (inclusive) to `toKey` (exclusive). |
| | **`subMap(K from, boolean fromInc, K to, boolean toInc)`** | Returns a view of the map within the specified range, with configurable boundary inclusions. |
| **Map Order Configuration** | **`descendingMap()`** | Inverts the map, returning a reverse-order view of its entries. |
| | **`descendingKeySet()`** | Returns a reverse-order set view of the keys contained in the map. |
| | **`comparator()`** | Returns the comparator used for ordering keys, or null if natural order is used. |
| **Standard Lookup & Query** | **`get(Object key)`** | Looks up the value mapped to a specific key, returning null if missing. |
| | **`containsKey(Object key)`** | Checks if a specific key exists in the map. |
| | **`containsValue(Object value)`** | Checks if one or more keys map to a specific value. |
| | **`size()`** | Returns the total number of key-value mappings in the map. |
| | **`isEmpty()`** | Checks if the map contains no key-value mappings. |
| **Modification & Updates** | **`put(K key, V value)`** | Associates a key with a value, replacing the old value if it exists. |
| | **`putAll(Map<? extends K, ? extends V> m)`** | Copies all mappings from the specified map into this map. |
| | **`remove(Object key)`** | Removes the mapping for a key from the tree if present. |
| | **`clear()`** | Deletes all elements from the map. |
| **Collection Views** | **`keySet()`** | Provides a unique `Set` view of all keys in the map. |
| | **`values()`** | Returns a `Collection` view of all values in the map. |
| | **`entrySet()`** | Returns a `Set` view of all key-value entry pairs. |

📊 I can help you write a Java program demonstrating how to use these NavigableMap methods to solve a custom range-query problem like a dynamic leaderboard.