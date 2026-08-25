
import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededtoBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        int ans = 0;
        for (int i : tickets) {
            q.offer(i);
        }

        int index = k;
        while (!q.isEmpty()) {
                    }

        return ans;
    }
}
