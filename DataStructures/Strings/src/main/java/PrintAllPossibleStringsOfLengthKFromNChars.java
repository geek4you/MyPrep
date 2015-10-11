/**
 * Created by chanumolu on 8/12/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/print-all-combinations-of-given-length/
 *
 * Print all possible strings of length k that can be formed from a set of n characters
Given a set of characters and a positive integer k, print all possible strings of length k that can be formed from the given set.

Examples:

Input:
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb


Input:
set[] = {'a', 'b', 'c', 'd'}, k = 1
Output:
a
b
c
d
For a given set of size n, there will be n^k possible strings of length k. The idea is to start from an empty output string (we call it prefix in following code). One by one add all characters to prefix. For every character added, print all possible strings with current prefix by recursively calling for k equals to k-1.
Following is Java implementation for same.
 */
public class PrintAllPossibleStringsOfLengthKFromNChars {

    public static void print(char[] arr, int k){
        int n = arr.length;
        printUtil(arr, "", n, k);
    }

    public static void printUtil(char[] arr,String prefix, int end , int k ){
        // Base case: k is 0, print prefix
        if (k == 0) {
            System.out.println(prefix);
            return;
        }

        // One by one add all characters from set and recursively
        // call for k equals to k-1
        for (int i = 0; i < end; ++i) {

            // Next character of input added
            String newPrefix = prefix + arr[i];

            // k is decreased, because we have added a new character
            printUtil(arr, newPrefix, end, k - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("First Test");
        char set1[] = {'a', 'b'};
        int k = 3;
        print(set1, k);

        System.out.println("\nSecond Test");
        char set2[] = {'a', 'b', 'c', 'd'};
        k = 1;
        print(set2, k);

        System.out.println("\nThrid Test");
        char set3[] = {'a', 'b', 'c', 'd'};
        k = 3;
        print(set3, k);
    }

}
