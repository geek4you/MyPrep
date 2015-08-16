import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by chanumolu on 7/8/15.
 */
public class MaxHeap<E extends Comparable<E>> {

    List<E> h = new ArrayList<E>();

    public MaxHeap() {

    }

    public MaxHeap(E[] keys) {
        for (E key : keys) {
            h.add(key);
        }

        for (int pos = (h.size()) / 2 - 1; pos >= 0; pos--) {
        // h.size()/2-1 to 0 will cover all parents and all parents move down.
            moveDown(pos);
        }
    }

    public void add(E key) {
        h.add(key);
        moveUp(h.size() - 1);
    }


    public void moveUp(int pos) {
        int parent;
        while (pos > 0) {
            parent = (pos - 1) / 2;
            // check if child is less than parent
            if (h.get(pos).compareTo(h.get(parent)) < 0) {
                break;
            }

            Collections.swap(h, pos, parent);
            pos = parent;
        }

    }

    public void moveDown(int pos) {
        int child;
        while (pos <= h.size() / 2 - 1) {
            child = 2 * pos + 1;

            // check for left child and then right
            if ((child < h.size() - 1) && h.get(pos).compareTo(h.get(child)) > 0)
                child++;

            // check if right child exist
            if (child > h.size() - 1)
                return;

            if (h.get(pos).compareTo(h.get(child)) > 0)
                break;

            Collections.swap(h, pos, child);
            pos = child;
        }
    }

    public E remove() {
        E returnVal;
        if (!h.isEmpty()) {
            returnVal = h.get(0);
            Collections.swap(h,0,h.size()-1);
            h.remove(h.size()-1);
            moveDown(0);
            return returnVal;
        } else
            return null;
    }


}
