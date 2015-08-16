/**
 * Created by chanumolu on 8/12/15.
 */

import java.util.Arrays;

/**
 * @link :
 * Anagram Substring Search (Or Search for all permutations)
 * <p>
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all
 * occurrences of pat[] and its permutations (or anagrams) in txt[]. You may assume that n > m.
 * Expected time complexity is O(n)
 * <p>
 * Examples:
 * <p>
 * 1) Input:  txt[] = "BACDGABCDA"  pat[] = "ABCD"
 * Output:   Found at Index 0
 * Found at Index 5
 * Found at Index 6
 * 2) Input: txt[] =  "AAABABAA" pat[] = "AABA"
 * Output:   Found at Index 0
 * Found at Index 1
 * Found at Index 4
 * <p>
 * We can achieve O(n) time complexity under the assumption that alphabet size is fixed which is typically true as we have
 * maximum 256 possible characters in ASCII. The idea is to use two count arrays:
 * <p>
 * 1) The first count array store frequencies of characters in pattern.
 * 2) The second count array stores frequencies of characters in current window of text.
 * <p>
 * The important thing to note is, time complexity to compare two count arrays is O(1) as the number of elements in them
 * are fixed (independent of pattern and text sizes). Following are steps of this algorithm.
 * 1) Store counts of frequencies of pattern in first count array countP[]. Also store counts of frequencies of characters
 * in first window of text in array countTW[].
 * <p>
 * 2) Now run a loop from i = M to N-1. Do following in loop.
 * …..a) If the two count arrays are identical, we found an occurrence.
 * …..b) Increment count of current character of text in countTW[]
 * …..c) Decrement count of first character in previous window in countWT[]
 * <p>
 * 3) The last window is not checked by above loop, so explicitly check it.
 */

public class AnagramSearch {

    // This function returns true if contents of arr1[] and arr2[]
// are same, otherwise false.
    public static boolean compare(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    // This function search for all permutations of pat[] in txt[]
    public static void search(char[] pat, char[] txt) {
        int m = pat.length, n = txt.length;

        // countP[]:  Store count of all characters of pattern
        // countTW[]: Store count of current window of text
        int[] countP = new int[256];
        Arrays.fill(countP, 0);
        int[] countTW = new int[256];

        // 1st window
        Arrays.fill(countP, 0);
        for (int i = 0; i < m; i++) {
            (countP[pat[i]])++;
            (countTW[txt[i]])++;
        }

        // Traverse through remaining characters of pattern
        for (int i = m; i < n; i++) {
            // Compare counts of current window of text with
            // counts of pattern[]
            if (compare(countP, countTW))
                System.out.println("Found at Index " + (i - m) );

            // Add current character to current window
            (countTW[txt[i]])++;

            // Remove the first character of previous window
            countTW[txt[i - m]]--;
        }

        // Check for the last window in text
        if (compare(countP, countTW))
            System.out.println("Found at Index " + (n - m) );
    }

    public static void main(String[] args) {
        char txt[] = {'B','A','C','D','G','A','B','C','D','A','B'};
        char pat[] = {'A','B','C','D'};
        search(pat, txt);
    }

}
