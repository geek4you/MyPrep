/**
 * Created by chanumolu on 8/9/15.
 */

/*
 Explanation in this video
 @link : https://www.youtube.com/watch?v=vK_q-C-kXhs
 */
public class QuickSortInPlace {


    /*
     partition method for arr[p..q]
     returns pivot.
    */
    public static int partition(int[] arr, int p , int q){

        // let first element be the pivot
        int x = arr[p];

        int i =p;

        for(int j = p+1 ; j<=q ; j++){
            if(arr[j]<=x){
                int tmp = arr[j];
                arr[j] = arr[i+1];
                arr[i+1] = tmp;
                i++;
            }
        }

        //swap pivot and i
        arr[p] = arr[i];
        arr[i] = x;

        return i;

    }

    public static void quickSort(int[] arr,int p, int q){

        if(p<q){
            int r = partition(arr,p,q);
            quickSort(arr,p,r);
            quickSort(arr,r+1,q);
        }

    }


    public static void main(String[] args) {

        int[] arry = {10,2,3,40,32,1,0,43,100,5};
        quickSort(arry,0,arry.length-1);

        for(int i : arry){
            System.out.print(i+" ");
        }

    }
}
