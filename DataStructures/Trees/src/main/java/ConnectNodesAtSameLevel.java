/**
 * Created by chanumolu on 7/8/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * <p>
 * Connect nodes at same level
 */
public class ConnectNodesAtSameLevel {
    public static void connectSameLevel(BNode1 root) {

        if (null == root)
            return;

        BNode1 current = root;
        BNode1 prev = null;

        Deque<BNode1> queue = new ArrayDeque<BNode1>();
        queue.add(current);
        int n = 1;
        boolean stop = false;
        while (!stop) {
            while (!queue.isEmpty() && n >= 0) {
                prev = current;
                current = queue.poll();
                if (prev != current)
                    prev.nextRight = current;
                --n;

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }

            current.nextRight = null;

            n = queue.size();

            if (n == 0)
                stop = true;
        }

    }

    public static void main(String[] args) {
        /* Constructed binary tree is
            10
          /   \
        8      2
      /
    3
  */
        BNode1 root = new BNode1(10);
        root.left = new BNode1(8);
        root.right = new BNode1(2);
        root.left.left = new BNode1(3);

        connectSameLevel(root);

        // Let us check the values of nextRight pointers
        System.out.println(root.left.nextRight);
    }
}

class BNode1 {

    int data;
    BNode1 left;
    BNode1 right;
    BNode1 nextRight;

    BNode1(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }

    @Override
    public String toString() {
        return "BNode1{" +
                "data=" + data +
                ", nextRight=" + nextRight +
                '}';
    }
}


