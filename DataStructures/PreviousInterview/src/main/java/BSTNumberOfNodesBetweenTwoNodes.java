/**
 * Created by chanumolu on 8/18/15.
 */

/**
 * @link : http://www.quora.com/Given-a-BST-and-two-integers-a-and-b-a-b-how-can-we-find-the-number-of-nodes-s-t-a-node-value-b-in-O-log-n
 *
 * Let us assume BST is created in such a way that for any node n all the nodes m whose values are less than the value of n constitute the left sub-tree of n and all the nodes k whose values are greater than that of n constitute the right sub-tree of n. I also assume in the BST no two nodes have same value.

Algorithm steps

Lets consider the root of the BST. If value of root is less than a then pick the right sub-tree of the root as the tree and start the algorithm again. If value of root is greater than b then pick the left sub-tree of the root as the tree and start the algorithm again. If a < value of root < b then put the root in the list, pick the left sub-tree and right sub-tree of the root and GOTO step 2.
If the value of the root of left sub-tree is same as a then put all the nodes in the right sub-tree of this current root to list and GOTO step 5.
If the value of the root of left sub-tree is less than a then pick the right sub-tree of the current root as the current tree and GOTO step 2.
If the value of the root of left sub-tree is greater than a then put the root and its right sub-tree in the list and pick the left sub-tree of the current root as the current tree and GOTO step 2.
With the right sub-tree of BST root check if the value of the root of this right sub-tree is same as b then put all the nodes in the left sub-tree of this root in the list.
If the value of the root of right sub-tree is less than b then put the root and its left sub-tree in the list and pick the right sub-tree of the current root as the current tree and GOTO step 5.
If the value of the root of sub-tree is greater than b then pick the left sub-tree of the current root as the current tree and GOTO step 5.
Repeat the steps as long as there are nodes in the BST not yet visited.

But I think this algorithm has time complexity of O(N) and we cannot perform this enumeration in less than O(N) time complexity.

Edit: I think while creating the BST if you precomputes the size of left sub-tree and right sub-tree for each node then you can reduce the time complexity of counting to O(logN) as searching in a BST has that figure for complexity. But I am not very sure here.
 */
public class BSTNumberOfNodesBetweenTwoNodes {
}
