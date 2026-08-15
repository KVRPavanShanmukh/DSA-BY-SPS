
public class Valid_Parantheses_String {

    public boolean CheckValidity(String s) {
        int oc = 0;
        int cc = 0;
        for (char i : s.toCharArray()) {
            if (i == '*') {
                cc++; //assuming that '*' == '('
                oc--; //assuming that '*' == ')'
            } else if (i == '(') {
                oc++;
                cc++;
            } else {
                oc--;
                cc--;
            }

            if (cc < 0) {
                return false;
            }
            if (oc < 0) {
                oc = 0;
            }
        }
        return oc == 0;
    }

    public static void main(String[] args) {
        String s = "(*))";
        Valid_Parantheses_String vps = new Valid_Parantheses_String();
        System.out.println(vps.CheckValidity(s));
    }
}
