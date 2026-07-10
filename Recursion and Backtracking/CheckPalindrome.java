
import java.util.Scanner;

public class CheckPalindrome {

    // public boolean isPal(String s, int l, int h, int n) {
    //     if (l > h) {
    //         return true;
    //     }
    //     if (s.charAt(l) != s.charAt(h)) {
    //         return false;
    //     }
    //     return isPal(s, l + 1, h - 1, n);
    // }
    
    public boolean isPal(String s, int l, int n) {
        if (l > n) {
            return true;
        }
        if (s.charAt(l) != s.charAt(n - l - 1)) {
            return false;
        }
        return isPal(s, l + 1, n - l - 1);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter String's size : ");
        int n = s.nextInt();
        System.out.print("Enter String : ");
        String s1 = s.next();
        CheckPalindrome cp = new CheckPalindrome();
        System.out.println(cp.isPal(s1, 0, n - 1) ? "True" : "False");
        s.close();
    }
}
