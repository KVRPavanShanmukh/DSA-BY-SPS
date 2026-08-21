import java.util.*;

class Node {
    int val;
    Node l, r;

    Node(int val) {
        this.val = val;
        l = r = null;
    }
}

public class RootToLeaf {

    public Node buildTree(Scanner s, int n) {
        if (n == 0) {
            return null;
        }

        int val = s.nextInt();

        if (val == -1) {
            return null;
        }

        Node root = new Node(val);

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (i < n && !q.isEmpty()) {

            Node curr = q.poll();

            // Left child
            if (i < n) {
                val = s.nextInt();
                i++;

                if (val != -1) {
                    curr.l = new Node(val);
                    q.add(curr.l);
                }
            }

            // Right child
            if (i < n) {
                val = s.nextInt();
                i++;

                if (val != -1) {
                    curr.r = new Node(val);
                    q.add(curr.r);
                }
            }
        }

        return root;
    }

    public static boolean RTL(Node rt, List<Integer> path, int x) {

        if (rt == null) {
            return false;
        }

        // Add current node
        path.add(rt.val);

        // Target found
        if (rt.val == x) {
            return true;
        }

        // Search left or right
        if (RTL(rt.l, path, x) || RTL(rt.r, path, x)) {
            return true;
        }

        // Backtrack
        path.remove(path.size() - 1);

        return false;
    }

    public static List<Integer> solve(Node root, int x) {

        List<Integer> path = new ArrayList<>();

        RTL(root, path, x);

        return path;
    }

    public static int HeightOfTree(Node rt) {

        if (rt == null) {
            return 0;
        }

        int lh = HeightOfTree(rt.l);
        int rh = HeightOfTree(rt.r);

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int t = s.nextInt();

        while (t-- > 0) {

            int n = s.nextInt();
            int target = s.nextInt();

            // Correct class
            RootToLeaf bt = new RootToLeaf();

            Node root = bt.buildTree(s, n);

            List<Integer> ans = RootToLeaf.solve(root, target);

            sb.append(ans).append("\n");
        }

        System.out.print(sb);

        s.close();
    }
}