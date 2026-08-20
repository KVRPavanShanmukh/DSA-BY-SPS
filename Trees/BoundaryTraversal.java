import java.util.ArrayList;
import java.util.List;

class Node {

    Node l, r;
    int val;

    public Node(int val) {
        this.val = val;
        l = r = null;
    }
}

public class BoundaryTraversal {
    public static boolean isLeaf(Node rt) {
        if (rt.l == null && rt.r == null) {
            return true;
        }
        return false;
    }

    public static void LBoundaryTraversal(Node rt, List<Integer> ls) {
        Node curr = rt.l;
        while (curr != null) {
            if (!isLeaf(curr)) {
                ls.add(curr.val);
            }
            if (curr.l != null) {
                curr = curr.l;
            } else {
                curr = curr.r;
            }
        }
    }

    public static void RBoundaryTraversal(Node rt, List<Integer> ls) {
        List<Integer> temp = new ArrayList<>();
        Node curr = rt.r;
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.val);
            }
            if (curr.r != null) {
                curr = curr.r;
            } else {
                curr = curr.l;
            }
        }

        for (int i = temp.size() - 1; i >= 0; --i) {
            ls.add(temp.get(i));
        }
    }

    void addLeaves(Node rt, List<Integer> res) {
        if (isLeaf(rt)) {
            res.add(rt.val);
            return;
        }
        if (rt.l != null) { //move left mama
            addLeaves(rt.l, res);
        }
        if (rt.r != null) { //move right mama
            addLeaves(rt.r, res);
        }
    }

    List<Integer> printBoundary(Node rt) {
        List<Integer> res = new ArrayList<>();
        if (rt == null) {
            return res;
        }
        if (!isLeaf(rt)) {
            res.add(rt.val);
        }

        //Cult code pattern below!!
        LBoundaryTraversal(rt, res);
        addLeaves(rt, res);
        RBoundaryTraversal(rt, res);

        return res;
    }

    void printResult(List<Integer> result) {
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.l = new Node(2);
        root.r = new Node(3);
        root.l.l = new Node(4);
        root.l.r = new Node(5);
        root.r.l = new Node(6);
        root.r.r = new Node(7);

        BoundaryTraversal bt = new BoundaryTraversal();
        List<Integer> result = bt.printBoundary(root);
        System.out.print("Boundary Traversal: ");
        bt.printResult(result);
    }
}
