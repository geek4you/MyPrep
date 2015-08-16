/**
 * Created by chanumolu on 7/5/15.
 */

/**
 * @link :
 *
 * About Duplicates:
In this solution, we will assume that duplicates are not allowed in the binary tree. Why?

Consider the following case:

preorder = {7, 7}
inorder = {7, 7}
We can construct the following trees which are both perfectly valid solutions.

7                     7
/           or          \
7                         7
 */


/**
 * TODO: optimizing
 * We left out some details on how we search the root value’s index in the inorder sequence. How about a simple
 * linear search? If we assume that the constructed binary tree is always balanced, then we can guarantee the run time
 * complexity to be O(N log N), where N is the number of nodes. However, this is not necessarily the case and the
 * constructed binary tree can be skewed to the left/right, which has the worst complexity of O(N2).

 A more efficient way is to eliminate the search by using an efficient look-up mechanism such as hash table. By hashing
 an element’s value to its corresponding index in the inorder sequence, we can do look-ups in constant time. Now, we
 need only O(N) time to construct the tree, which theoretically is the most efficient way.
 */
public class BuildTreeFromInorderAndPreorder {

    public static Node buildTree(char[] in , char[] pre){

        return buildTreeUtil(in, pre, 0, in.length-1);
    }

    static int preIndex = 0;
    // function does not check if a tree is not formed from the given inputs
    public static Node buildTreeUtil(char[] in , char[] pre, int beg, int end){
        if (beg > end)
            return null;

        System.out.println("preIndex: "+preIndex);
        System.out.println("preOrder[preIndex]: " +pre[preIndex]);
        // Pick current node from Preorder traversal using preIndex
        // and increment preIndex
        Node tmp = new Node(pre[preIndex++]);

        // if leaf node return node
        if(beg==end)
            return tmp;

        // get the index in in[]
        int in_index = search(in, beg, end, tmp.data);

        // get the left and right children
        tmp.left = buildTreeUtil(in, pre, beg, in_index - 1);
        tmp.right = buildTreeUtil(in, pre, in_index, end);

        return tmp;
    }

    public static int search(char[] ary, int beg, int end, int key){

        for(int i =beg; i<=end;i++){
            if(key==ary[i])
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
        Node root = buildTree(in, pre);

        LevelOrderTraversal.bfs(root);
    }
}
