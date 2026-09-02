/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        int[] p = new int[num1.length()];
        int[] q = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            p[i] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < num2.length(); i++) {
            q[i] = num2.charAt(i) - '0';
        }

        int[] result = new int[num1.length() + num2.length()];
        for (int i = p.length - 1; i >= 0; i--) {
            for (int j = q.length - 1; j >= 0; j--) {
                int product = p[i] * q[j];
                int pos1 = i + j;
                int pos2 = i + j + 1;
                int sum = product + result[pos2];
                result[pos2] = sum % 10;
                result[pos1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        /*
        int result = 0;
        for (int digit : p) {
            result = result * 10 + digit;
        }
        
        int result1 = 0;
        for (int digit : q) {
            result1 = result1 * 10 + digit;
        }
        long FinalResult = result * result1;
        String str = String.valueOf(FinalResult);
        return str;
        */

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings ms = new MultiplyStrings();
        System.out.println((ms.multiply(num1, num2)));
    }
}
