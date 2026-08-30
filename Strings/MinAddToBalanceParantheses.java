/*
A parentheses string is valid if and only if:
It is the empty string,
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
Return the minimum number of moves required to make s valid.

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
 */

public class MinAddToBalanceParantheses {

    public int minAddToMakeValid(String s) {
        int i = 0;
        int cnt = 0;
        int neg = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                cnt--;
                if (cnt < 0) {
                    cnt = 0;
                    neg++;
                }
            }
            i++;
        }
        return Math.abs(cnt + neg);
    }

    public static void main(String[] args) {
        String str = "())";
        MinAddToBalanceParantheses mab = new MinAddToBalanceParantheses();
        System.err.println(mab.minAddToMakeValid(str));
    }
}
