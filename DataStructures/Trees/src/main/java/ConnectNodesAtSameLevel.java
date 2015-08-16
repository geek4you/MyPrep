/**
 * Created by chanumolu on 7/8/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * @link : http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 *
 * Connect nodes at same level
 *
 *
 */
public class ConnectNodesAtSameLevel {
    // TODO: solve this problem
    public void connectSameLevel(BNode1 root){

        if(null == root)
            return;

        Deque<Pair> queue = new ArrayDeque<Pair>();

        BNode1 current = root;
        queue.add(new Pair(current,0));
        BNode1 prev = null;
        int pLevel = 0;
        while(queue.size()!=0){
            Pair p = queue.poll();
            current = p.node;
        }

    }
}

class BNode1{

    int data;
    BNode1 left;
    BNode1 right;
    BNode1 nextRight;

    BNode1(int data){
        this.data = data;
        this.left = null;
        this.right = null;
        this.nextRight = null;
    }
}

class Pair{
    BNode1 node;
    int level;
    Pair(BNode1 node, int level){
        this.node = node;
        this.level = level;
    }
}
