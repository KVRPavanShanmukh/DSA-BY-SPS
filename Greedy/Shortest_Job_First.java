
import java.util.Arrays;

/*
Problem Statement: Given a list of job durations representing the time it takes to complete each job.
Implement the Shortest Job First algorithm to find the average waiting time for these jobs.

Example 1:
Input:jobs = [3, 1, 4, 2, 5]
Output: 4           
Explanation:  
The first job that will be executed is of duration 1 and the waiting time for it will be 0.
After the first job, the next shortest job with a duration of 2 will be executed with a waiting time of 1.
Following the completion of the first two jobs, the next shortest job with a duration of 3 will be executed with a waiting time of 3 (1 + 2).
Then, the job with a duration of 4 will be executed with a waiting time of 6 (1 + 2 + 3).
Finally, the job with the longest duration of 5 will be executed with a waiting time of 10 (1 + 2 + 3 + 4). Hence, the average waiting time is calculated as (0 + 1 + 3 + 6 + 10) / 5 = 20 / 5 = 4.
 */
public class Shortest_Job_First {

    public static float Jobs(int a[]) {
        Arrays.sort(a);
        int n = a.length;

        float TotalwaitingTime = 0;
        int waitingTime = 0;

        for (int i = 0; i < n; i++) {
            TotalwaitingTime += waitingTime;
            waitingTime += a[i];
        }
        return (float) (TotalwaitingTime / n);
    }

    public static void main(String[] args) {
        // int a[] = {3, 1, 4, 2, 5};
        int a[] = {4, 3, 7, 1, 2};
        System.out.println(Jobs(a));
    }
}
