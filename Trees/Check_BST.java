
import java.util.*;

class Node {

    int val;
    Node l, r;

    Node(int val) {
        this.val = val;
        l = r = null;
    }
}

public class Check_BST {

    public static boolean CheckBST(Node rt) {
        return ValidateBST(rt, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean ValidateBST(Node rt, long mini, long maxi) {
        if (rt == null) {
            return true;
        }
        if (rt.val <= mini || rt.val >= maxi) {
            return false;
        }
        return ValidateBST(rt.l, mini, rt.val) && ValidateBST(rt.r, rt.val, maxi);
    }

    public static Node BuildTreeFromArr(int a[]) {
        int n = a.length;
        if (n == 0) {
            return null;
        }

        Node b[] = new Node[n];
        for (int i = 0; i < n; i++) {
            if (a[i] != -1) {
                b[i] = new Node(a[i]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (b[i] != null) {
                int l = 2 * i + 1;
                int r = 2 * i + 2;

                if (l < n) {
                    b[i].l = b[l];
                }
                if (r < n) {
                    b[i].r = b[r];
                }
            }
        }
        return b[0];
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            Check_BST bst = new Check_BST();
            Node rt = Check_BST.BuildTreeFromArr(a);

            System.out.println(bst.CheckBST(rt) ? "True" : "False");
        }
    }
}
