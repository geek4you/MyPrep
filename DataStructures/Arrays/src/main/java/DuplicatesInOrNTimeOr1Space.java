/**
 * Created by chanumolu on 6/27/15.
 */

/**
 * @link : http://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
 *
 * Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 0 to n-1, with any of these numbers appearing any number of
times. Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.

 algo:
traverse the list for i= 0 to n-1 elements
{
check for sign of A[abs(A[i])] ;
if positive then
make it negative by   A[abs(A[i])]=-A[abs(A[i])];
else  // i.e., A[abs(A[i])] is negative
this   element (ith element of list) is a repetition
}

 Above algorithm doesn't handle the case where a[i]=0
 Can we use this for that??

if(arr[i]==0)

{

arr[abs(arr[i])]=0;

if(temp==0)

printf("%d ",0);

else

temp=0;

continue;

}
 */
public class DuplicatesInOrNTimeOr1Space {

    public static void duplicates1(int[] arry){
        for(int i=0;i<arry.length;i++){
            if(arry[Math.abs(arry[i])]<0){
                System.out.print(Math.abs(arry[i]));
            }else{
                    arry[Math.abs(arry[i])] = -arry[Math.abs(arry[i])];
            }
        }
    }

    public static void duplicates2(int [] arry) {
        int n = arry.length;
        for (int i = 0; i < n; i++)
            arry[arry[i] % n] += n;
        for (int i = 0; i < n ; i++)
            if (arry[i]/n > 1)
                System.out.println(i);;
    }

    public static void main(String[] args) {
        int[] arry = {1, 2, 3, 1, 3, 6, 6};
        duplicates2(arry);
    }
}
