import java.util.PriorityQueue;

class Person implements Comparable<Person> {

    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);  // Min-Heap based on age
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class PQ_With_Objects {

    public static void main(String[] args) {
        PriorityQueue<Person> pq = new PriorityQueue<>();

        pq.add(new Person("Alice", 30));
        pq.add(new Person("Bob", 25));
        pq.add(new Person("Charlie", 35));

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());  // Bob (25), Alice (30), Charlie (35)
        }
    }
}