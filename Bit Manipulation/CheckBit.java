
public class CheckBit {

    public boolean checkBit(int n, int i) {
        /*
        n = 5,i = 2
        5 = 1   0   1
        i = 0th 1st 2nd
        2nd bit is set.
         */
        return (n & (1 << (i - 1))) != 0;
    }

    public static void main(String[] args) {
        CheckBit cb = new CheckBit();
        System.out.println("Is the Bit Set: " + ((cb.checkBit(3, 1)) ? "Yes" : "No"));
    }
}