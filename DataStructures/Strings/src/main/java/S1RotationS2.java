/**
 * Created by chanumolu on 6/27/15.
 */

/**
 * Given two strings s1 and s2, write code to check if s2
 * is a rotation of s1 using only one call to isSubstring
 * (e.g., "waterbottle" is a rotation of "erbottlewat").
 */
public class S1RotationS2 {

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat"));
        System.out.println(isRotation("waterbottles", "erbottlewats"));
        System.out.println(isRotation("abcde", "abc"));
    }

    /**
     * Checks if the string s2 is a rotation of s1.
     * @param s1
     * @param s2
     * @return
     */
    public static boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        String s1s1 = s1 + s1;
        int index = s1s1.indexOf(s2);
        return index > -1;
    }
}
