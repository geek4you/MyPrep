/**
 * Created by chanumolu on 8/10/15.
 */

import java.util.Arrays;

/**
 * @link : http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/
 *
 * Print all permutations with repetition of characters
Given a string of length n, print all permutation of the given string. Repetition of characters is allowed.
Print these permutations in lexicographically sorted order
Examples:

Input: AB
Ouput: All permutations of AB with repetition are:
AA
AB
BA
BB

Input: ABC
Output: All permutations of ABC with repetition are:
AAA
AAB
AAC
ABA
...
...
CCB
CCC
For an input string of size n, there will be n^n permutations with repetition allowed. The idea is to fix the first
character at first index and recursively call for other subsequent indexes. Once all permutations starting with the
first character are printed, fix the second character at first index. Continue these steps till last character.
 */
public class PermutationsOfStringWithRepetitions {

    /* The main function that recursively prints all repeated permutations of
  the given string. It uses data[] to store all permutations one by one */
    public static void allLexicographicRecur (char[] str, char[] data, int last, int index){
        int i;

        // One by one fix all characters at the given index and recur for the
        // subsequent indexes
        for ( i=0; i<str.length; i++ ){
            // Fix the ith character at index and if this is not the last index
            // then recursively call for higher indexes
            data[index] = str[i] ;
            // If this is the last index then print the string stored in data[]
            if (index == last)
                System.out.println(data);
            else // Recur for higher indexes
                allLexicographicRecur (str, data, last, index+1);
        }
    }

    /* This function sorts input string, allocate memory for data (needed for
  allLexicographicRecur()) and calls allLexicographicRecur() for printing all
  permutations */
    public static void  allLexicographic(char[] str)
    {

        // Create a temp array that will be used by allLexicographicRecur()
        char[] data = new char[str.length] ;

        // Sort the input string so that we get all output strings in
        // lexicographically sorted order
        Arrays.sort(str);

        // Now print all permutaions
        allLexicographicRecur (str, data, str.length-1 , 0);

    }

    public static void main(String[] args) {
        char str[] = {'A','B','C'};
        System.out.println("All permutations with repetition:");
        allLexicographic(str);
    }
}
