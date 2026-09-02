
import java.util.Scanner;

class Node {

    Node l, r;
    int val;

    public Node(int val) {
        this.val = val;
        l = r = null;
    }
}

public class BST_FromPreOrder {

    private int index = 0;

    public Node bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private Node build(int[] preorder, int bound) {
        if (index == preorder.length || preorder[index] > bound) {
            return null;
        }

        Node rt = new Node(preorder[index++]);
        rt.l = build(preorder, rt.val);
        rt.r = build(preorder, bound);
        return rt;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = s.nextInt();
            Node rt = null;

            int a[] = new int[n];
            System.out.println("Enter leaves : ");
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            BST_FromPreOrder bstp = new BST_FromPreOrder();
            for (int i = 0; i < n; i++) {
                bstp.build(a, n);
            }
            sb.append("Node Address (random) : ").append(bstp.bstFromPreorder(a));
        }
        System.out.print(sb);
        s.close();
    }
}
