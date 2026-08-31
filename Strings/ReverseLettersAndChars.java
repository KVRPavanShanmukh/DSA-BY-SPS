/*
You are given a string s consisting of lowercase English letters and special characters.

Your task is to perform these in order:

Reverse the lowercase letters and place them back into the positions originally occupied by letters.
Reverse the special characters and place them back into the positions originally occupied by special characters.
Return the resulting string after performing the reversals.

 

Example 1:

Input: s = ")ebc#da@f("

Output: "(fad@cb#e)"

Explanation:

The letters in the string are ['e', 'b', 'c', 'd', 'a', 'f']:
Reversing them gives ['f', 'a', 'd', 'c', 'b', 'e']
s becomes ")fad#cb@e("
​​​​​​​The special characters in the string are [')', '#', '@', '(']:
Reversing them gives ['(', '@', '#', ')']
s becomes "(fad@cb#e)"
 */
public class ReverseLettersAndChars {

    public String reverseByType(String s) {
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
        i = 0;
        j = a.length - 1;
        while (i < j) {
            while (i < j && Character.isLetter(a[i])) {
                i++;
            }
            while (i < j && Character.isLetter(a[j])) {
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
