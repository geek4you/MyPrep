/**
 * Created by chanumolu on 6/23/15.
 */

/**
 * @link http://www.geeksforgeeks.org/segregate-even-and-odd-numbers/
 *Segregate Even and Odd numbers
Given an array A[], write a function that segregates even and odd numbers. The functions should put all even numbers f
irst, and then odd numbers.

Example
Input = {12, 34, 45, 9, 8, 90, 3}
Output = {12, 34, 8, 90, 45, 9, 3}

In the output, order of numbers can be changed, i.e., in the above example 34 can come before 12 and 3 can come before 9.

The problem is very similar to our old post Segregate 0s and 1s in an array,
and both of these problems are variation of famous Dutch national flag problem.
 *
 */
public class SegregateEvenOddNumbers {

    public static int[] segregate(int[] ary){
        int i=0 , j=ary.length-1;

        while (i<j){
            while(ary[i]%2==0)
                i++;

            while (ary[j]%2!=0)
                j--;

            if(i<j){
                int temp = ary[i];
                ary[i]=ary[j];
                ary[j]=temp;
                i++;
                j--;
            }
        }

        return ary;
    }

    public static void main(String[] args) {
        int[] ary = {12, 34, 45, 9, 8, 90, 3};
        int[] arry = segregate(ary);

        for(int i : arry)
            System.out.print(i+" ");
    }
}
