package Arrays;

/**
 * Created by chanumolu on 6/15/15.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A[] and a number x, check for pair in A[] with sum as x
 * Write a C program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly x
 * <p>
 * 1) Method1 : use sorting. After sorting, take two pointers front and back and move them.
 * Time : Time Complexity: Depends on what sorting algorithm we use. If we use Merge Sort or Heap Sort then (-)(nlogn)
 * in worst case. If we use Quick Sort then O(n^2) in worst case.
 * Auxiliary Space : Again, depends on sorting algorithm. For example auxiliary space is O(n) for merge sort and O(1) for Heap Sort.
 * </p>
 * <p>
 * 2) Method2 : Use HashMap
 */
public class ArrayHasGivenSumGivenX {

    // hashmap procedure
    public static void findSumS(int[] ary, int x) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for(int i : ary){
            if(map.containsKey(x-i)){
                System.out.println("Pair: "+i+" , "+(x-i));
                map.remove(x-i);
            }else{
                map.put(i,1);
            }
        }

        System.out.println("Done!!");
    }

    public static void main(String[] args) {
        int[] ary = {1, 4, 12, 45, 6, 10, 8};
        findSumS(ary,16);

    }
}
