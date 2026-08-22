class Node {
    Node l, r;
    int val;

    public Node(int val) {
        this.val = val;
        l = r = null;
    }
}

class Counter {
    int count = 0;
}

public class KthSmallestLargest {
    public static void findKthSmallest(Node rt, int k, Counter cnt, int[] result) {
        if (rt == null || cnt.count >= k) {
            return;
        }
        findKthSmallest(rt.l, k, cnt, result);
        cnt.count++;
        if (cnt.count == k) {
            result[0] = rt.val;
            return;
        }
        findKthSmallest(rt.r, k, cnt, result);
    }

    public static void findKthLargest(Node rt, int k, Counter cnt, int[] result) {
        if (rt == null || cnt.count >= k) {
            return;
        }
        findKthLargest(rt.r, k, cnt, result);
        cnt.count++;
        if (cnt.count == k) {
            result[0] = rt.val;
            return;
        }
        findKthLargest(rt.l, k, cnt, result);
    }

    public static int[] KthSmallestANDLargest(Node rt, int k) {
        if (rt == null) {
            return new int[]{};
        }

        int[] smallestRes = new int[1];
        int[] largestRes = new int[1];
        findKthSmallest(rt, k, new Counter(), smallestRes);
        findKthLargest(rt, k, new Counter(), largestRes);

        return new int[]{smallestRes[0], largestRes[0]};
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.l = new Node(1);
        root.r = new Node(4);
        root.l.r = new Node(2);

        int k = 1;
        int[] ans = KthSmallestANDLargest(root, k);
        System.out.println("Result: [" + ans[0] + ", " + ans[1] + "]");
    }
}