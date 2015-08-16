/**
 * Created by chanumolu on 8/9/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 1) choose any element as pivot
 2) partition the array into two partitions except the pivot.
 3) all elements less than pivot into first.
 4) all the elements greater than pivot into second.
 5) recursively sort the left and right partitions
 6) join the first partitions : pivot : second partition

 */

public class QuickSort {

    public static <T extends Comparable<? super T>> List<T> quickSort(List<T> arr) {

        if (!arr.isEmpty()) {
            T pivot = arr.get(0); //This pivot can change to get faster results
            System.out.println("pivot : " + pivot);
            List<T> partition1 = new LinkedList<T>();
            List<T> pivotList = new LinkedList<T>();
            List<T> partition2 = new LinkedList<T>();

            // Partition
            for (T i : arr) {
                if (i.compareTo(pivot) < 0)
                    partition1.add(i);
                else if (i.compareTo(pivot) > 0)
                    partition2.add(i);
                else
                    pivotList.add(i);
            }

            // Recursively sort sublists
            partition1 = quickSort(partition1);
            partition2 = quickSort(partition2);

            // Concatenate results
            partition1.addAll(pivotList);
            partition1.addAll(partition2);

            return partition1;
        }

        return arr;

    }


    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<Integer>();
        int[] arry = {10,2,3,40,32,1,0,43,100,5};
        for(int i: arry)
            arr.add(i);

        arr = quickSort(arr);

        for(Integer i : arr){
            System.out.print(i + " ");
        }

    }


}
