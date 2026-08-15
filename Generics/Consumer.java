// Generic Methods & Bounded Types

public class Consumer {

    public static <T extends Comparable<T>> T findMax(T a, T b) {
        if (a.compareTo(b) > 0) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Integer i1 = findMax(100, 150);
        System.out.println("Max is : " + i1 + " ");
        
        String s1 = findMax("Pushpa", "Shanmukh");
        System.out.println("King is : " + s1 + " ");

        System.err.println("boii boii");
    }
}
