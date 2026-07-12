/*
Fruit Into Baskets

Problem Statement: There is only one row of fruit trees on the farm, oriented left to right.
An integer array called fruits represents the trees, where fruits[i] denotes the kind of fruit 
produced by the ith tree.
The goal is to gather as much fruit as possible, adhering to the owner's stringent rules :

There are two baskets available, and each basket can only contain one kind of fruit. The quantity
 of fruit each basket can contain is unlimited.
Start at any tree, but as you proceed to the right, select exactly one fruit from each tree,
including the starting tree. One of the baskets must hold the harvested fruits.
Once reaching a tree with fruit that cannot fit into any basket, stop.
Return the maximum number of fruits that can be picked.

Examples
Input :fruits = [1, 2, 1]
Output :3
Explanation : We will start from first tree.
The first tree produces the fruit of kind '1' and we will put that in the first basket.
The second tree produces the fruit of kind '2' and we will put that in the second basket.
The third tree produces the fruit of kind '1' and we have first basket that is already holding
fruit of kind '1'. So we will put it in first basket.
Hence we were able to collect total of 3 fruits.


Input : fruits = [1, 2, 3, 2, 2]
Output : 4
Explanation : we will start from second tree.
The first basket contains fruits from second , fourth and fifth.
The second basket will contain fruit from third tree.
Hence we collected total of 4 fruits.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitsInBaskets {

    public static int BruteForce_Fruits(int a[], int n) {
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> hm = new HashMap<>();
            int cc = 0;
            for (int j = i; j < n; j++) {
                hm.put(a[j], hm.getOrDefault(a[j], 0) + 1);
                if (hm.size() > 2) {
                    break;
                }
                cc++;
            }
            maxLen = Math.max(maxLen, cc);
        }
        return maxLen;
    }

    public static int Fruits(int a[], int n) {
        int maxLen = 0;
        int l = 0;
        int r = 0;

        Map<Integer, Integer> hm = new HashMap<>();
        while (r < n) {
            hm.put(a[r], hm.getOrDefault(a[r], 0) + 1);

            while (hm.size() > 2) {
                hm.put(a[l], hm.get(a[l]) - 1);
                if (hm.get(a[l]) == 0) {
                    hm.remove(a[l]);
                }
                l++;
            }
            maxLen = Math.max(r - l + 1, maxLen);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter total #fruits of different types : ");
        int n = s.nextInt();
        System.out.println("Enter total fruits :");
        int a[] = new int[n];
        for (int idx = 0; idx < a.length; idx++) {
            a[idx] = s.nextInt();
        }

        System.out.println(Fruits(a, n));

        // System.out.println(BruteForce_Fruits(a, n));
        s.close();
    }
}
