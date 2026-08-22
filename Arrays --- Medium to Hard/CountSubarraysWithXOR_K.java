/*
Count the number of subarrays with given xor K
Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays
having bitwise XOR of all elements equal to k.

Input: A = [4, 2, 2, 6, 4] , k = 6
Output: 4
 */

public class CountSubarraysWithXOR_K {

    public static int BF_SubArraysWithK(int a[], int k) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((a[i] ^ a[i + 1]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a[] = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println(BF_SubArraysWithK(a, k));
    }
}
