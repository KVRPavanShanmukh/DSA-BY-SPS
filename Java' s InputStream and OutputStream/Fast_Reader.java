
import java.io.*;
import java.util.*;

public class Fast_Reader {

    BufferedReader br;
    StringTokenizer st;

    Fast_Reader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreElements()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    String nextLine() throws IOException {
        return br.readLine();
    }



    //Use it like this.
    public class Main {
        public static void main(String[] args) throws Exception {
            Fast_Reader in = new Fast_Reader();
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                System.out.println(x);
            }
        }
    }
}