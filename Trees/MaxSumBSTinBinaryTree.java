// Prerequisite : NumberOfBSTs.



//INCOMPLETE!!!


//No node class needed here!!
import java.util.Scanner;

class BST {

    int ans = 0;

    class Info {

        boolean isBst;
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;

        public Info(boolean isBst, int mini, int maxi, int sum) {
            this.isBst = isBst;
            this.mini = mini;
            this.maxi = maxi;
            this.sum = sum;
        }
    }

    public Info NumberOfBSTs(int a[], int i) {
        if (i >= a.length) {
            return new Info(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        Info leftInfo = NumberOfBSTs(a, left);
        Info rightInfo = NumberOfBSTs(a, right);
        int Currentsum = leftInfo.sum + a[i] + rightInfo.sum;

        Info currInfo = new Info(false, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        currInfo.mini = Math.min(a[i], Math.min(leftInfo.mini, rightInfo.mini));
        currInfo.maxi = Math.max(a[i], Math.max(leftInfo.maxi, rightInfo.maxi));

        if (leftInfo.isBst && rightInfo.isBst && leftInfo.maxi < a[i] && rightInfo.mini > a[i]) {
            ans++;
            currInfo.isBst = true;
        }
        return currInfo;
    }
}

public class MaxSumBSTinBinaryTree {

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
