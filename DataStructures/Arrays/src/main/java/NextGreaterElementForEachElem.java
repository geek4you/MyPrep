/**
 * Created by chanumolu on 6/25/15.
 */

import java.util.Stack;

/**
 * @link : http://www.geeksforgeeks.org/next-greater-element/
 * Next Greater Element
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 * <p>
 * Examples:
 * a) For any array, rightmost element always has next greater element as -1.
 * b) For an array which is sorted in decreasing order, all elements have next greater element as -1.
 * c) For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.
 * <p>
 * Element       NGE
 * 4      -->   5
 * 5      -->   25
 * 2      -->   25
 * 25     -->   -1
 * d) For the input array [13, 7, 6, 12}, the next greater elements for each element are as follows.
 * <p>
 * Element        NGE
 * 13      -->    -1
 * 7       -->     12
 * 6       -->     12
 * 12     -->     -1
 */
public class NextGreaterElementForEachElem {

    public static void nextGreaterElem(int[] ary) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(ary[0]);
        int i = 1;
        while (i < ary.length) {
            if (!stack.empty() && ary[i] > stack.peek()) {
                System.out.println("NGE of " + stack.pop() + " is " + ary[i]);
            }else{
                stack.push(ary[i]);
                i++;
            }
        }

        while (!stack.empty()){
            System.out.println("NGE of " + stack.pop() + " is -1" );
        }
    }

    public static void main(String[] args) {
       // int ary[] = {4, 5, 2, 25};
       // int []ary = {13,7,6,12};
        int[] ary = {4,3,2,1};
        nextGreaterElem(ary);
    }
}
