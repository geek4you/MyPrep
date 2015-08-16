/**
 * Created by Pradeep on 5/7/15.
 */

import java.util.HashMap;

/**
 * How to implement LRU caching scheme? What data structures should be used?

 We are given total possible page numbers that can be referred. We are also given cache (or memory) size (Number of page frames that cache can hold at a time). The LRU caching scheme is to remove the least recently used frame when the cache is full and a new page is referenced which is not there in cache.
 Please see the Galvin book for more details (see the LRU page replacement slide here <link>http://www.wiley.com/college/silberschatz6e/0471417432/slides/pdf2/mod10.2.pdf</link>).

 We use two data structures to implement an LRU Cache.

 1. A Queue which is implemented using a doubly linked list. The maximum size of the queue will be equal to the total number of frames available (cache size).
 The most recently used pages will be near front end and least recently pages will be near rear end.

 2. A Hash with page number as key and address of the corresponding queue node as value.

 When a page is referenced, the required page may be in the memory. If it is in the memory, we need to detach the node of the list and bring it to the front of the queue.
 If the required page is not in the memory, we bring that in memory. In simple words, we add a new node to the front of the queue and update the corresponding node address in the hash. If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue, and add the new node to the front of queue.

 Note: Initially no page is in the memory.
 */
public class LRUCacheImpl {
    int size; // size of LRU Cache
    LRUQueue queue = null;
    HashMap<Integer,DoubleLinkedListNode> map = null;

    public LRUCacheImpl(int size) {
        this.size = size;
        this.queue = new LRUQueue(size);
        map = new HashMap<Integer,DoubleLinkedListNode>();
    }

    /** This function is called when a page with given 'pageNumber' is referenced from cache (or memory).
     * There are two cases:
     1. Frame is not there in memory, we bring it in memory and add to the front
     of queue
     2. Frame is there in memory, we move the frame to front of queue
     */
     void referencePage(int pageNumber){
         DoubleLinkedListNode reqPage = map.get(pageNumber);
         // the page is not in cache, bring it
         if(null == reqPage){
             queue.enQueue(map,pageNumber);
         }
         // page is there and not at front, change pointer
         else if( reqPage != queue.front){
             // Unlink rquested page from its current location
             // in queue.
             reqPage.prev.next = reqPage.next;
             if(null != reqPage.next){
                 reqPage.next.prev = reqPage.prev;
             }

             // If the requested page is rear, then change rear
             // as this node will be moved to front
             if(reqPage == queue.rear){
                 queue.rear = reqPage.prev;
                 queue.rear.next = null;
             }

             // Put the requested page before current front
             reqPage.next = queue.front;
             reqPage.prev = null;

             // Change prev of current front
             reqPage.next.prev = reqPage;

             // Change front to the requested page
             queue.front = reqPage;
         }
     }

    public static void main(String[] args) {
        // Let cache can hold 4 pages
        LRUCacheImpl lruCache = new LRUCacheImpl(4);

        // Let us refer pages 1, 2, 3, 1, 4, 5
        lruCache.referencePage(1);
        lruCache.referencePage(2);
        lruCache.referencePage(3);
        lruCache.referencePage(1);
        lruCache.referencePage(4);
        lruCache.referencePage(5);

        // Let us print cache frames after the above referenced pages
        System.out.println(lruCache.queue.front.pageNumber);
        System.out.println(lruCache.queue.front.next.pageNumber);
        System.out.println(lruCache.queue.front.next.next.pageNumber);
        System.out.println(lruCache.queue.front.next.next.next.pageNumber);
    }


}

class DoubleLinkedListNode{
    public int pageNumber;
    public DoubleLinkedListNode prev;
    public DoubleLinkedListNode next;

    public DoubleLinkedListNode(int pageNumber) {
        this.pageNumber = pageNumber;
        prev = next =null;
    }
}

class LRUQueue{
    int count;  // Number of filled frames
    int noOfFrames;  // total number of frames
    DoubleLinkedListNode front, rear;

    public LRUQueue(int noOfFrames) {
        // The queue is empty
        this.count = 0;
        // Number of frames that can be stored in memory
        this.noOfFrames = noOfFrames;
        this.front = this.rear = null;
    }

    // utility to check if queue is empty
    boolean isEmpty(){
        return null==rear;
    }

    boolean areAllFramesFull(){
        return this.count==this.noOfFrames;
    }

    // A utility function to delete a frame from queue
    void deQueue(){
        if(isEmpty())
           return;

        // If this is the only node in list, then change front
        if(this.front==this.rear)
            front=null;

        // Change rear and remove the previous rear
        DoubleLinkedListNode temp = this.rear;
        this.rear=this.rear.prev;
        if(null != this.rear)
            this.rear.next = null;

        // decrement the number of full frames by 1
        this.count--;
    }

    // A function to add a page with given 'pageNumber' to both queue
    // and hashMap
    HashMap<Integer,DoubleLinkedListNode> enQueue(HashMap<Integer,DoubleLinkedListNode> map, int pageNumber){
        // If all frames are full, remove the page at the rear
        if(areAllFramesFull()){
            // remove page from hash
            map.remove(pageNumber);
            deQueue();
        }

        // Create a new node with given page number,
        // And add the new node to the front of queue
        DoubleLinkedListNode temp = new DoubleLinkedListNode(pageNumber);
        temp.next = this.front;

        // If queue is empty, change both front and rear pointers
        if(isEmpty()){
            this.rear = this.front = temp;
        }else{ // Else change the front
            this.front.prev = temp;
            this.front = temp;
        }

        // Add page entry to hash map also
        map.put(pageNumber,temp);

        // increment number of full frames
        this.count++;

        return map;
    }

}
