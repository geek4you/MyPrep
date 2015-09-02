import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by chanumolu on 8/19/15.
 */
public class MedianOf2Arrays1 {

    public static double findMedianSortedArrays(int A[], int B[]) {
        //create a min heap and a max heap

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((A.length+B.length)/2+2, new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
                if(a>b)
                    return 1;
                else if(a<b)
                    return -1;
                else
                    return 0;
            }
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((A.length+B.length)/2+2, new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
                if(a>b)
                    return -1;
                else if(a<b)
                    return 1;
                else
                    return 0;
            }
        });

        //set two pointers for arr A and arr B
        int pA = 0;
        int pB = 0;

        //put one elem in the each heap by making comparsion of A[0] and B[0]
        //if one arr is empty, we should handle it by only puting elem in the heap from the non-empty arr
        if(A.length != 0 && B.length!=0){
            minHeap.add(Math.max(A[pA],B[pB]));
            maxHeap.add(Math.min(A[pA],B[pB]));
        }
        else if(A.length == 0 && B.length!=0)
            minHeap.add(B[pB]);
        else if(A.length != 0 && B.length==0)
            minHeap.add(A[pA]);
        //don't forget increment them to iterate the rest of the arr
        pA++;
        pB++;
        //when iterate the rest, if the arr is not empty, we put the elem in the one the heaps by making comparsion with the
        //peek value of the two heaps
        //each time we need to check if two heap size differ less or equal to 1

        while(pA<A.length || pB<B.length)
        {
            if(pA<A.length){
                if(maxHeap.isEmpty() || A[pA]<=maxHeap.peek())
                    maxHeap.add(A[pA]);
                else
                    minHeap.add(A[pA]);
            }

            if(pB<B.length){
                if(maxHeap.isEmpty() || B[pB]<=maxHeap.peek())
                    maxHeap.add(B[pB]);
                else
                    minHeap.add(B[pB]);
            }

            if(minHeap.size()-maxHeap.size()>1)
                maxHeap.add(minHeap.poll());
            else if(maxHeap.size()-minHeap.size()>1)
                minHeap.add(maxHeap.poll());
            pA++;
            pB++;
        }

        //in the end, if even numbers, we get the mean of the two peeks
        //else get the peek from the heap has more elems than the other
        if(minHeap.size()==maxHeap.size())
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        else if(minHeap.size()>maxHeap.size())
            return minHeap.peek();
        else
            return maxHeap.peek();
    }

    public static void main(String[] args) {
        int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};

        System.out.println("Median: " + findMedianSortedArrays(ar1, ar2));
    }
}
