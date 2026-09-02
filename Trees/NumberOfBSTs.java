/*
Given a binary tree with unique elements, find the number of Binary Search Trees that are part of the given binary tree and have unique root nodes.
The input is given in the form of a complete binary tree, represented using an array. Assuming the array index starts from 1, the root will be at index 1. For every index i, its child nodes will be at 2i and 2i+1.

Input Format
The first line of input contains T - the number of test cases. It's followed by 2T lines. The first line of each test case contains N - the number of nodes in the tree. The next line contains N integers - nodes of the binary tree in the form of a Complete Binary Tree.

Output Format
For each test case, print the number of Binary Search Trees, separated by a newline.

Constraints
1 <= T <= 1000
1 <= N <= 1000
0 <= ar[i] <= 100000

Example
Input
5
11
92 10 963 5 334 928 973 2 9 263 860
9
156 153 6947 149 154 1761 7230 9 152
4
40 49 87 651
5
449 792 594 688 618
15
736 43 882 3 460 741 887 0 42 247 465 739 844 886 888

Output
10
9
2
3
15

 */

import java.util.*;

//No node class needed here!!
class BST {

    int ans = 0;

    class Info {
        boolean isBst;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;

        public Info(boolean isBst, int mini, int maxi) {
            this.isBst = isBst;
            this.mini = mini;
            this.maxi = maxi;
        }
    }

    public Info NumberOfBSTs(int a[], int i) {
        if (i >= a.length) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        Info leftInfo = NumberOfBSTs(a, left);
        Info rightInfo = NumberOfBSTs(a, right);

        Info currInfo = new Info(false, Integer.MAX_VALUE, Integer.MIN_VALUE);
        currInfo.mini = Math.min(a[i], Math.min(leftInfo.mini, rightInfo.mini));
        currInfo.maxi = Math.max(a[i], Math.max(leftInfo.maxi, rightInfo.maxi));

        if (leftInfo.isBst && rightInfo.isBst && leftInfo.maxi < a[i]
                && rightInfo.mini > a[i]) {
            ans++;
            currInfo.isBst = true;
        }
        return currInfo;
    }
}

public class NumberOfBSTs {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        //INPUT IS ALREADY A CBT, NO NEED TO CREATE THE TREE AGAIN.
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            BST bst = new BST();
            bst.NumberOfBSTs(a, 0);
            System.out.println(bst.ans);
        }
    }
}