/*
Given a string s, reverse the string according to the following rules:

All the characters that are not English letters remain in the same position.
All the English letters (lowercase or uppercase) should be reversed.
Return s after reversing it.

 

Example 1:

Input: s = "ab-cd"
Output: "dc-ba"
Example 2:

Input: s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char a[] = s.toCharArray();
        int i = 0;
        int j = a.length - 1;

        while (i < j) {
            while (i < j && !Character.isLetter(a[i])) {
                i++;
            }
            while (i < j && !Character.isLetter(a[j])) {
                j--;
            }
            if (i < j) {
                char c = a[i];
                a[i] = a[j];
                a[j] = c;
                i++;
                j--;
            }
        }
        return new String(a);
    }
}
