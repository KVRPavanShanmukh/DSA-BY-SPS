
public class Kadane_Algo {

    public static int Kadanes_Algo(int a[]) {
        int n = a.length;
        int ans = a[0];
        int Curans = 0;

        for (int i = 0; i < n; i++) {
            Curans += a[i];
            ans = Math.max(ans, Curans);
            if (Curans < 0) {
                Curans = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = a.length;
        System.err.println(Kadane_Algo.Kadanes_Algo(a));
    }
}
