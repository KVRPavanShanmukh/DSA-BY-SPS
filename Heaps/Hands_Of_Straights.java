
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Hands_Of_Straights {

    public static boolean  groupSize(int a[],int k){
        if(a.length % k != 0){
            return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Hands_Of_Straights hos = new Hands_Of_Straights();
        ArrayList<Integer> ls = new ArrayList<>(Arrays.asList(1, 2, 3, 6, 2, 3, 4, 7, 8));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int groupsize = s.nextInt();
        int subarray = groupsize;
        int size = ls.size();
        
        while (size-- != 0) {
            for (int i = 0; i < subarray; i++) {
                pq.add(ls.remove(i));
            }

            if(subarray == 0){
                subarray = groupsize;
            }
        }
    }
}
