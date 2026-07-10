/* 
Problem Statement: Given an integer n, return all binary strings of length n that do not contain
consecutive 1s. Return the result in lexicographically increasing order.
A binary string is a string consisting only of characters '0' and '1'.

Example 1:
Input:
 n = 3  
Output:
 ["000", "001", "010", "100", "101"]  
Explanation:
 All binary strings of length 3 that do not contain consecutive 1s.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateBinaryStrings {

    private void geneStrings(int i, int n, ArrayList<Character> ls) {
        if (i == n) {
            print(ls);
            return;
        }

        ls.add('0');
        geneStrings(i + 1, n, ls);
        ls.remove(ls.size() - 1);

        if (ls.isEmpty() || ls.get(ls.size() - 1) == '0') {
            ls.add('1');
            geneStrings(i + 1, n, ls);
            ls.remove(ls.size() - 1);
        }
    }

    private void print(ArrayList<Character> ls) {
        for (char i : ls) {
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.println("Enter size of array: ");
            
            int n = s.nextInt();
            System.out.println("The BinaryStrings are : ");
            
            GenerateBinaryStrings gbs = new GenerateBinaryStrings();
            gbs.geneStrings(0, n, new ArrayList<>());
        }catch(Exception e){
            System.err.println("No i/p");
        }
    }
}
