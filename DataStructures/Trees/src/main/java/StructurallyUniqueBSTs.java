/**
 * Created by chanumolu on 7/5/15.
 */

import java.util.ArrayList;

/**
 * @link : http://edwardliwashu.blogspot.com/2013/01/unique-binary-search-tree-ii.html
 *
 *
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.
1         3     3      2      1
\       /     /      / \      \
3     2     1      1   3      2
/     /       \                 \
2     1         2                 3
 */
public class StructurallyUniqueBSTs {

    public ArrayList<Node> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Node> result = new ArrayList<Node>();
        if (n==0) {
            Node root = null;
            result.add(root);
            return result;
        }
        result = generateTrees(1, n);
        return result;
    }

    public ArrayList<Node> generateTrees(int start, int end){
        ArrayList<Node> result = new ArrayList<Node>();
        if (start > end) {
            Node root = null;
            result.add(root);
            return result;
        }
        for( int i = start; i <= end ; i++){
            ArrayList<Node> leftList = generateTrees(start, i - 1);
            ArrayList<Node> rightList = generateTrees(i + 1, end);
            for (int j = 0; j < leftList.size(); j++) {
                for (int k = 0; k < rightList.size(); k++) {
                    Node root = new Node(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
