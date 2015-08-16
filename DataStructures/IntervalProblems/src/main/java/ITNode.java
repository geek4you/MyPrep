/**
 * Created by chanumolu on 8/4/15.
 */
public class ITNode {
        // Structure to represent a node in Interval Search Tree
        Interval interval;  // 'i' could also be a normal variable
        int max;
        ITNode left, right;

    public ITNode(Interval interval) {
        this.interval = interval;
        this.max = interval.end;
        this.left = null;
        this.right = null;
    }


}
