/**
 * Created by chanumolu on 11/1/15.
 */

/**
 * link : http://www.geeksforgeeks.org/find-the-two-repeating-elements-in-a-given-array/
 * Find the two repeating elements in a given array
 You are given an array of n+2 elements. All elements of the array are in range 1 to n. And all elements occur once
 except two numbers which occur twice. Find the two repeating numbers.

 For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5

 The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output
 should be 4 2.

 Algorithm:

 Traverse the array. Do following for every index i of A[].
 {
 check for sign of A[abs(A[i])] ;
 if positive then
 make it negative by   A[abs(A[i])]=-A[abs(A[i])];
 else  // i.e., A[abs(A[i])] is negative
 this   element (ith element of list) is a repetition
 }

 */
public class FindTwoRepeatingElems {

    static void printRepeatingElem(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[Math.abs(arr[i])]>0){
                arr[Math.abs(arr[i])] = - arr[Math.abs(arr[i])];
            }else{
                System.out.println(Math.abs(arr[i])+" is duplicate !!");
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 2, 1};
        printRepeatingElem(arr);

    }
}
