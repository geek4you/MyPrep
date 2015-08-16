/**
 * Created by chanumolu on 8/4/15.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Give a bunch of words and a string pattern containing ?, which can match any char.
 * Return the matched words.
 * <p>
 * solution: just scan the words once to match the pattern one by one.
 * O(n) time, O(1) space
 */
public class PatternSearchQuestionMark {

    public static boolean checkMatch(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {

            if (str2.charAt(i) == '?') continue;

            if (str2.charAt(i) != str1.charAt(i)) return false;
        }

        return true;
    }

    public static List<String> wordsMatch(List<String> list, String pattern) {
        List<String> res = new ArrayList<String>();
        for (String st : list) {
            if(checkMatch(st,pattern)){
                res.add(st);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("rbadd");
        list.add("rb c ");
        list.add("rbfw ");
        list.add("rb ca");
        list.add("rbfce");
        String pattern = "rb?c?";

        List<String> res = wordsMatch(list,pattern);

        for(String st: res){
            System.out.println(res);
        }
    }
}
