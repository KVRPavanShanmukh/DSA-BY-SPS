import java.util.*;

public class SingleNumbeer {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter test cases");
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int a[] = new int[n];
            System.out.println("Enter Array elements!");
            for (int i = 0; i < n; i++) {
                a[i] = s.nextInt();
            }

            int res = 0;
            for(int i =0;i<n;i++){
                res^=a[i];
            }
            System.out.println("SingleNumber present is : "+res);
        }
    }
}