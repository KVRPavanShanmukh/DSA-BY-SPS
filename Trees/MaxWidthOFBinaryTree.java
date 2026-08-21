/*
Problem Statement:
Given a Binary Tree, return its maximum width. The maximum width of a Binary Tree is the maximum diameter among all its levels. The width or diameter of a level is the number of nodes between the leftmost and rightmost nodes.
Input: Binary Tree: 1 2 3 5 6 -1 9
Output: Maximum Width: 4
Explanation: 
Level 3 is the widest level of the Binary Tree and whose end-to-end width is 4 comprising of nodes: {5, 6, null, 9}.
*/

import java.util.*;

class Pair {
    Node node;
    int index;
    Pair(Node node, int index) {
        this.node = node;
        this.index = index;
    }
}

public class MaxWidthOFBinaryTree {
    //  public Node buildTree(Scanner s, int n) {
    //         if (n == 0) {
    //             return null;
    //         }
    //         int val = s.nextInt();
//         if (val == -1) {
//             return null;
//         }
//         Node root = new Node(val);
//         Queue<Node> q = new LinkedList<>();
//         q.add(root);

//         int i = 1;
//         while (i < n && !q.isEmpty()) {
    //             Node curr = q.poll();
    //             if (i < n) {
    //                 val = s.nextInt();
    //                 i++;
    //                 if (val != -1) {
    //                     curr.l = new Node(val);
    //                     q.add(curr.l);
    //                 }
    //             }
    //             if (i < n) {
    //                 val = s.nextInt();
    //                 i++;
    //                 if (val != -1) {
    //                     curr.r = new Node(val);
    //                     q.add(curr.r);
    //                 }
    //             }
    //         }
    //         return root;
    //     }
    public int Width(Node rt) {
        if (rt == null) {
            return 0;
        }

        int maxW = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(rt, 0));

        while (!q.isEmpty()) {
            int sz = q.size();
            int minIdx = q.peek().index;

            int first = 0;
            int last = 0;

            for (int i = 0; i < sz; i++) {
                Pair p = q.poll();
                Node curr = p.node;
                int currIdx = p.index - minIdx;
                if (i == 0)            first = currIdx;
                if (i == sz - 1)       last = currIdx;
                if (curr.l != null)     q.offer(new Pair(curr.l, 2 * currIdx + 1));
                if (curr.r != null)     q.offer(new Pair(curr.r, 2 * currIdx + 2));
            }
            maxW = Math.max(maxW, last - first + 1);
        }
        return maxW;
    }

    public static void main(String[] args) {
        Node root = new Node(1);

        root.l = new Node(3);
        root.r = new Node(2);

        root.l.l = new Node(5);
        root.l.r = new Node(3);

        root.r.r = new Node(9);

        MaxWidthOFBinaryTree mwb = new MaxWidthOFBinaryTree();

        System.out.println("Maximum width: " + mwb.Width(root));
    }
}