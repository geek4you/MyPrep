/**
 * Created by chanumolu on 6/27/15.
 */

/**
 *Determine if a string has all unique characters.
 *
 *  Can also use hashmap
 */
public class UniqueChars {

    public static void main(String[] args) {
        System.out.println(uniqueASCII("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(uniqueASCII("aaa"));
        System.out.println(uniqueASCII("aAbBcC"));
    }

    /**
     * Determine if the input String s has all unique characters.
     * This implementation assumes only ASCII characters.
     * @param s
     * @return
     */
    public static boolean uniqueASCII(String s) {
        int[] counts = new int[256];
        char[] chars = s.toCharArray();

        for(char c : chars) {
            counts[c]++;
            if(counts[c] > 1) {
                return false;
            }
        }

        return true;
    }
}
