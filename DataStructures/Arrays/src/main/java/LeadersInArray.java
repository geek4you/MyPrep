/**
 * Created by chanumolu on 6/17/15.
 */

/**
 * @link http://www.geeksforgeeks.org/leaders-in-an-array/
 * Write a program to print all the LEADERS in the array. An element is leader if it is greater than all the elements
 * to its right side. And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2},
 * leaders are 17, 5 and 2.
 *
 * Scan all the elements from right to left in array and keep track of maximum till now. When maximum changes
 * it’s value, print it.
 */
public class LeadersInArray {

    private static void leaders(int[] ary){
        int max = Integer.MIN_VALUE;
        for(int i=ary.length-1; i>=0 ; i--){
            if(ary[i]>max){
                System.out.println("Leader found: "+ary[i]);
                max = ary[i];
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {16, 17, 4, 3, 5, 2};
        leaders(arr);
    }

}
