/**
 * Created by Pradeep on 5/7/15.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HeapImpl<E extends Comparable<E>> {
    List<E> h = new ArrayList<E>();

    public HeapImpl() {

    }

    public HeapImpl(E[] keys) {

        for (E e : keys)
            h.add(e);
        //above 2 lines can be replaced by this
        //Collections.addAll(h,keys);

        for (int pos = h.size() / 2 - 1; pos >= 0; pos--) {
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
            if (h.get(pos).compareTo(h.get(parent)) < 0)
                break;

            Collections.swap(h, pos, parent);
            pos = parent;
        }
    }


    public void moveDown(int pos) {
        int child;
        while (pos < h.size() - 1) {
            child = 2 * pos + 1;
            if ((child < h.size() - 1) && (h.get(child + 1).compareTo(h.get(child)) > 0))
                child++;

            if (child < h.size() - 1 && h.get(pos).compareTo(h.get(child)) > 0)
                break;

            if(child<h.size())
            Collections.swap(h, pos, child);
            pos = child;
        }
    }

    public E remove() {
        E returnVal;
        if (h.size() != 0)
            returnVal = h.get(0);
        else {
            return null;
        }

        Collections.swap(h, 0, h.size() - 1);
        h.remove(h.size() - 1);

        moveDown(0);
        return returnVal;

    }
}
