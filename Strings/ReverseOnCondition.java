/*
Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that you have written. Typing other characters works as expected.

You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.

Return the final string that will be present on your laptop screen.

 

Example 1:

Input: s = "string"
Output: "rtsng"
Explanation: 
After typing first character, the text on the screen is "s".
After the second character, the text is "st". 
After the third character, the text is "str".
Since the fourth character is an 'i', the text gets reversed and becomes "rts".
After the fifth character, the text is "rtsn". 
After the sixth character, the text is "rtsng". 
Therefore, we return "rtsng".
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseOnCondition {

    public String finalString(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        boolean reverse = false;

        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                reverse = !reverse;
            } else if (!reverse) {
                dq.addLast(ch);
            } else {
                dq.addFirst(ch);
            }
        }

        StringBuilder ans = new StringBuilder();
        if (!reverse) {
            while (!dq.isEmpty()) {
                ans.append(dq.removeFirst());
            }
        } else {
            while (!dq.isEmpty()) {
                ans.append(dq.removeLast());
            }
        }

        return ans.toString();
    }
}
