import java.util.LinkedList;
import java.util.Queue;

public class Lunch {

    public int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> queue = new LinkedList<>();
        for (int student : students) {
            queue.offer(student);
        }

        int sandwichIndex = 0;
        int rotations = 0;

        while (!queue.isEmpty() && sandwichIndex < sandwiches.length) {
            if (queue.peek() == sandwiches[sandwichIndex]) {
                queue.poll();             // Student takes sandwich
                sandwichIndex++;          // Move to next sandwich
                rotations = 0;            // Reset because progress was made
            }
            else {
                // Student goes to the back
                queue.offer(queue.poll());
                rotations++;

                // Everyone has refused this sandwich
                if (rotations == queue.size()) {
                    break;
                }
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};

        Lunch l = new Lunch();
        System.out.println(l.countStudents(students, sandwiches));
    }
}