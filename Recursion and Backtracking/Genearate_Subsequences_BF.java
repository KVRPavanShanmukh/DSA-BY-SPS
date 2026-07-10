
import java.util.Scanner;

public class Genearate_Subsequences_BF {

    public String GenerateSubSeq(long n){
        
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Genearate_Subsequences_BF gb = new Genearate_Subsequences_BF();
        gb.GenerateSubSeq(n);
        s.close();
    }
}
