
import java.util.*;

class Node {

    int val;
    Node l, r;

    Node(int val) {
        this.val = val;
        l = r = null;
    }
}

// Stores the value of the rt and its depth level
class NodeInfo {

    int val;
    int depth;

    NodeInfo(int val, int depth) {
        this.val = val;
        this.depth = depth;
    }
}

class BST {

    public Node insertIntoBST(Node rt, int val) {
        if (rt == null) {
            return new Node(val);
        }

        Node curr = rt;
        while (true) {
            if (val < curr.val) {
                if (curr.l == null) {
                    curr.l = new Node(val);
                    break;
                }
                curr = curr.l;
            } else {
                if (curr.r == null) {
                    curr.r = new Node(val);
                    break;
                }
                curr = curr.r;
            }
        }
        return rt;
    }

    // Your DFS logic tracking both Horizontal Length (hd) and Depth
    public void traverse(Node rt, int hd, int depth, Map<Integer, NodeInfo> tm) {
        if (rt == null) {
            return;
        }

        // Add if we haven't seen this horizontal distance OR if this rt is closer to the root
        if (!tm.containsKey(hd) || depth < tm.get(hd).depth) {
            tm.put(hd, new NodeInfo(rt.val, depth));
        }

        // Traverse left: horizontal distance decreases, depth increases
        traverse(rt.l, hd - 1, depth + 1, tm);
        // Traverse right: horizontal distance increases, depth increases
        traverse(rt.r, hd + 1, depth + 1, tm);
    }

    public void topViewOfTree(Node rt, StringBuilder sb) {
        // TreeMap keeps the horizontal distances sorted (leftmost to rightmost)
        Map<Integer, NodeInfo> tm = new TreeMap<>();
        traverse(rt, 0, 0, tm);
        for (NodeInfo info : tm.values()) {
            sb.append(info.val).append(" ");
        }
        sb.append("\n");
    }
}

public class TopView_BST {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();

            BST bst = new BST();
            Node rt = null;
            System.out.println("Enter leaves : ");
            for (int i = 0; i < n; i++) {
                rt = bst.insertIntoBST(rt, s.nextInt());
            }
            bst.topViewOfTree(rt, sb);
        }
        System.out.print(sb);
        s.close();
    }
}
