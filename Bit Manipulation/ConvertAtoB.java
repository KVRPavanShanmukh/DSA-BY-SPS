import java.util.*;

public class ConvertAtoB {

    public int AtoB(int a,int b){
        int count = 0;
        long xor = a ^ b;
        while(xor>0){
            count+=(xor&1);
            xor>>=1;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int a = s.nextInt();
            int b = s.nextInt();
            ConvertAtoB cab = new ConvertAtoB();
            long res = cab.AtoB(a, b);
            System.out.println("Count / Number of steps taken to convert A to B is: "+res);
            // System.out.println(res);;
        }
    }

}