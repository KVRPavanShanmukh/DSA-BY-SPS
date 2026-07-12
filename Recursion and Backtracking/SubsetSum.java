
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
Subset Sum : Sum of all Subsets

Problem Statement: Given an array print all the sum of the subset generated from it, in the increasing
order.
Examples
Input: N = 3, arr[] = {5,2,1}
Output: 0,1,2,3,5,6,7,8
Explanation: We have to find all the subset’s sum and print them.in this case the generated
subsets are [ [], [1], [2], [2,1], [5], [5,1], [5,2]. [5,2,1],so the sums we get will
be  0,1,2,3,5,6,7,8

Input: N=3,arr[]= {3,1,2}
Output: 0,1,2,3,3,4,5,6
Explanation: We have to find all the subset’s sum and print them.in this case the generated subsets
are [ [], [1], [2], [2,1], [3], [3,1], [3,2]. [3,2,1],so the sums we get will be  0,1,2,3,3,4,5,6


Algo:
Initialize an empty list to store sums
Create a recursive function taking index and current sum as parameters
If index equals N, push the current sum into the list and return
Recursively call the function including the current element (sum + arr[index])
Recursively call the function excluding the current element (sum remains the same)
Call the function starting from index 0 and sum 0
Sort the result list and print it
 */
public class SubsetSum {

    public void RecursiveSubsetSum(int i, int CurrentSum, int a[], ArrayList<Integer> ls) {
        if (i == a.length) {
            ls.add(CurrentSum);
            return;
        }
        RecursiveSubsetSum(i + 1, CurrentSum + a[i], a, ls);

        RecursiveSubsetSum(i + 1, CurrentSum, a, ls);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int n = s.nextInt();
        System.out.print("Enter ele's of array: ");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        SubsetSum ss = new SubsetSum();
        System.out.println("Subsets Sum is : ");
        
        List<Integer> ls = new ArrayList<>();
        ss.RecursiveSubsetSum(0, 0, a, (ArrayList<Integer>) ls);
        Collections.sort(ls);
        System.out.println(ls);
        s.close();
    }
}
