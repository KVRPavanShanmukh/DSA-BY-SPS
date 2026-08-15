// A simple generic class that holds a Key-Value pair
// The Generic Class (Multiple Type Parameters)

public class Producer<K, V> {   //we are not encouraged to declare the wrapper classes here.

    private K key;
    private V value;

    public Producer(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Pair is : {Name = " + key + ", marks = " + value + "}";
    }

    public static void main(String[] args) {

        // Creating a Pair mapping a String to an Integer
        Producer<String, Integer> score = new Producer<>("Alice", 19);
        System.out.println(score);

        // Creating a Pair mapping an Integer to a String
        Producer<Integer, String> error = new Producer<>(404, "Not Found");
        System.err.println(error);
    }
}