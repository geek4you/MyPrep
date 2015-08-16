import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by chanumolu on 7/7/15.
 */

public class BalanceParanthesis {
    public static boolean isBalanced(String in) {
        Deque<Character> st = new ArrayDeque<Character>();

        for (char chr : in.toCharArray()) {
            switch (chr) {

                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;

                case ']':
                    if (st.isEmpty() || st.pop() != '[')
                        return false;
                    break;
                case ')':
                    if (st.isEmpty() || st.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (st.isEmpty() || st.pop() != '{')
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }

    public static void main(String args[]) {
        if (args.length != 0) {
            if (isBalanced(args[0]))
                System.out.println(args[0] + " is balanced");
            else
                System.out.println(args[0] + " is not balanced");
        }
    }
}