import java.util.Stack;

public class ValidParantheses {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '{' || ch == '[' || ch == '(') {
                st.push(ch);
            } else {
                if (st.empty()) {
                    return false;
                }
                char top = st.pop();
                if ((ch == ')' && top == '(')
                        || (ch == ']' && top == '[')
                        || (ch == '}' && top == '{')) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        System.out.println("Valid ?: " + isValid(s1));
        System.out.println("Valid ?: " + isValid(s2));
        System.out.println("Valid ?: " + isValid(s3));
    }
}
