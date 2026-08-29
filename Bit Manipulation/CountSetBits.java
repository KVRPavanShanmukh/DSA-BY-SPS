public class CountSetBits {
    public static int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            c += (n & 1);
            n >>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        System.err.println(hammingWeight(5));
        /*
        5 = 1 0 1 
        SetBits = 2
        */
    }
}