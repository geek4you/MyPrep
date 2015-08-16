/**
 * Created by chanumolu on 7/11/15.
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @link : http://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
 *
 * Check whether a given Binary Tree is Complete or not
 *
 * Check whether a given Binary Tree is Complete or not | Set 1 (Iterative Solution)
Given a Binary Tree, write a function to check whether the given Binary Tree is Complete Binary Tree or not.

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all
nodes are as far left as possible */


// TODO: complete this problem
public class BinaryTreeIsCompleteOrNot {

    public static boolean isCompleteTree(Node root){
        if(null==root)
            return true;

        Deque<Node> queue = new ArrayDeque<Node>();

        Node current = root;
        // flag to check that remaining nodes are leaf nodes.
        boolean leafNodes_rem = false;

        while(current != null || !queue.isEmpty()){
            if(current!=null){

                queue.push(current);
            }
        }

        return false;
    }
}
