/*
Problem Statement: You are given a list of tasks represented by uppercase English letters ('A' to 'Z'), and an integer n representing a cooldown interval between two same tasks. Each task takes exactly 1 CPU interval to complete. Tasks can be executed in any order, but identical tasks must be separated by at least n intervals, during which the CPU may remain idle or execute other tasks.
Return the minimum number of CPU intervals required to complete all the tasks .
Input :  tasks = ["A","A","A","B","B","B"], n = 2
Output :  8
Explanation : One valid execution order is:
A -> B -> idle -> A -> B -> idle -> A -> B
Total intervals = 8

 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Task_Scheduler {

    public int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of each task
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Step 2: Create a max heap (priority queue in reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq.values()) {
            maxHeap.add(count);
        }

        // Total time required
        int time = 0;

        // Step 3: Process tasks in cycles of size (n + 1)
        while (!maxHeap.isEmpty()) {

            // Temporary list to store tasks of current cycle
            List<Integer> temp = new ArrayList<>();

            // Set cycle size as cooldown + 1
            int cycle = n + 1;

            // Track number of tasks processed in current cycle
            int i = 0;

            // Run up to (n+1) tasks or until heap is empty
            while (i < cycle && !maxHeap.isEmpty()) {

                // Pick the most frequent task
                int count = maxHeap.poll();

                // Decrease frequency since task is used once
                count--;

                // If task still remains, store it for next cycle
                if (count > 0) {
                    temp.add(count);
                }

                // Count 1 unit time for this task
                time++;
                i++;
            }

            // Step 4: Push remaining tasks from temp back into the heap
            for (int rem : temp) {
                maxHeap.add(rem);
            }

            // Step 5: If heap is not empty, add idle time
            if (!maxHeap.isEmpty()) {
                time += (cycle - i);
            }
        }

        // Return total time taken
        return time;
    }

// Driver class
    public static void main(String[] args) {
        Task_Scheduler ts = new Task_Scheduler();
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;
        System.out.println(ts.leastInterval(tasks, n));
    }
}
