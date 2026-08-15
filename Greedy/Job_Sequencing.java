/*
Problem Statement: You are given a set of N jobs where each job comes with a deadline and profit.
The profit can only be earned upon completing the job within its deadline.
Find the number of jobs done and the maximum profit that can be obtained.
Each job takes a single unit of time and only one job can be performed at a time.
 */

import java.util.Arrays;

class Triad {

    int JobID;
    int Deadline;
    int Profit;

    public Triad(int JobID, int Deadline, int Profit) {
        this.JobID = JobID;
        this.Deadline = Deadline;
        this.Profit = Profit;
    }
}

class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class Job_Sequencing {

    public Pair<Integer, Integer> Job_Scheduling(Triad a[], int n) {
        // Sort Jobs in descending order of profit
        Arrays.sort(a, (x, y) -> y.Profit - x.Profit);

        // Find the job with the maximum deadline
        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, a[i].Deadline);
        }

        // The slot array tracks which job is assigned to which time slot. 
        // 1-based indexing is used, so size is maxDeadline + 1.
        int slot[] = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);

        int CountJobs = 0;
        int JobProfit = 0;

        for (int i = 0; i < n; i++) {
            // Loop from the deadline down to 1 (j > 0)
            for (int j = a[i].Deadline; j > 0; j--) {
                // If the slot is empty, schedule the job here
                if (slot[j] == -1) {
                    slot[j] = i;
                    CountJobs++;
                    JobProfit += a[i].Profit;
                    break;
                }
            }
        }
        return new Pair<>(CountJobs, JobProfit);
    }

    public static void main(String[] args) {
        Job_Sequencing js = new Job_Sequencing();
        int n = 4;

        // Cleaned up initialization using the new Triad constructor
        Triad[] a = new Triad[]{
            new Triad(1, 4, 20),
            new Triad(2, 1, 10),
            new Triad(3, 1, 40), // Changed deadline from 2 to 1
            new Triad(4, 1, 30) // Changed deadline from 2 to 1
        };

        Triad[] b = new Triad[]{
            new Triad(1, 4, 20),
            new Triad(2, 1, 10),
            new Triad(3, 1, 40), // Changed deadline from 2 to 1
            new Triad(4, 1, 30) // Changed deadline from 2 to 1
        };

        Pair<Integer, Integer> ans1 = js.Job_Scheduling(a, n);
        Pair<Integer, Integer> ans2 = js.Job_Scheduling(b, n);

        System.out.println("Number of executable Jobs with their Profits");
        System.out.println("Jobs Count : " + ans1.getKey() + "Profit : " + ans1.getValue());
        System.out.println("Jobs Count : " + ans2.getKey() + "Profit : " + ans2.getValue());
    }
}
