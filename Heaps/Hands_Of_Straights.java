
import java.util.Scanner;
import java.util.TreeMap;

public class Hands_Of_Straights {

    public static boolean HandsOFStrt(int a[], int SubarraySize) {
        if (a.length % SubarraySize != 0) {
            return false;
        }
        //Learn Tree map from Collections Framework folder to solve this problem.

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i : a) {
            tm.put(i, tm.getOrDefault(i, 0) + 1);
        }

        while (!tm.isEmpty()) {
            int fstKey = tm.firstKey();
            int FreqFstKey = tm.get(fstKey);

            for (int i = 0; i < SubarraySize; i++) {
                int card = fstKey + i;
                if (!tm.containsKey(card) || tm.get(card) < FreqFstKey) {
                    return false;
                }

                if (tm.get(card) == FreqFstKey) {
                    tm.remove(card);
                } else {
                    tm.put(card, tm.get(card) - FreqFstKey);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Hands_Of_Straights hos = new Hands_Of_Straights();
        int a[] = {1, 2, 3, 2, 3, 4, 6, 7, 8};
        System.out.println(hos.HandsOFStrt(a, 3));
    }
}
