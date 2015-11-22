/**
 * Created by chanumolu on 11/1/15.
 */

/**
 * Sort an array of 0s, 1s and 2s
 Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first,
 then all 1s and all 2s in last.

 Example
 Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

 The problem is similar to our old post Segregate 0s and 1s in an array, and both of these problems are variation of
 famous Dutch national flag problem.

 The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:

 a[1..Lo-1] zeroes (red)
 a[Lo..Mid-] ones (white)
 a[Mid..Hi] unknown
 a[Hi+1..N] twos (blue)
 The unknown region is shrunk while maintaining these conditions

 Lo := 1; Mid := 1; Hi := N;
 while Mid <= Hi do
 Invariant: a[1..Lo-1]=0 and a[Lo..Mid-1]=1 and a[Hi+1..N]=2; a[Mid..Hi] are unknown.
 case a[Mid] in
 0: swap a[Lo] and a[Mid]; Lo++; Mid++
 1: Mid++
 2: swap a[Mid] and a[Hi]; Hi–
 */
public class DutchNationalFlagProblem {


    public static void sort012(int[] arr){
        int low = 0;
        int high = arr.length-1;
        int mid =0;
        int temp =0 ;

        while(mid<=high){
            switch (arr[mid]){
                case 0:
                    // swap low and mid
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    // swap mid and high
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};

        System.out.println("Array after sorting: ");
        sort012(arr);

        for(int i : arr)
            System.out.printf("%d",i);
    }
}
