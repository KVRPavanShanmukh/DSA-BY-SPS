import java.io.*;
import java.util.*;

public class Buffered_Reader {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            System.out.println(x);
        }
    }
}