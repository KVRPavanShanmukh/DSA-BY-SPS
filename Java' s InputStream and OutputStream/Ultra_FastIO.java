import java.io.*;

class Fast_Scanner {

    private final InputStream in = System.in;
    private final byte[] buffer = new byte[1 << 16];

    private int ptr = 0, len = 0;

    private int read() throws IOException {
        if(ptr >= len){
            len = in.read(buffer);
            ptr = 0;
            if(len <= 0) return -1;
        }

        return buffer[ptr++];
    }

    int nextInt() throws IOException {
        int c;
        while((c = read()) <= ' ');
        int sign = 1;

        if(c == '-') {
            sign = -1;
            c = read();
        }

        int val = 0;
        while(c > ' ') {
            val = val * 10 + c - '0';
            c = read();
        }
        return val * sign;
    }
}