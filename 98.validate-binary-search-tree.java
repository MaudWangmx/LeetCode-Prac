/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (27.76%)
 * Likes:    4177
 * Dislikes: 554
 * Total Accepted:    727.7K
 * Total Submissions: 2.6M
 * Testcase Example:  '[2,1,3]'
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * ⁠   2
 * ⁠  / \
 * ⁠ 1   3
 * 
 * Input: [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * ⁠   5
 * ⁠  / \
 * ⁠ 1   4
 * / \
 * 3   6
 * 
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {


    private boolean testAllElement(int flag, TreeNode root){
        ArrayList<TreeNode> nodes = new ArrayList<>();
        TreeNode t;
        if (flag == 1){
            if (root.left == null) 
                return true;
            nodes.add(root.left);
            while (!nodes.isEmpty()){
                t = nodes.get(0);
                if (t.left != null)
                    nodes.add(t.left);
                if (t.right != null)
                    nodes.add(t.right);
                if (t.val >= root.val)
                    return false;
                nodes.remove(0);
            }
            return true;
        }
        else{
            if (root.right == null) 
                return true;
            nodes.add(root.right);
            while (!nodes.isEmpty()){
                t = nodes.get(0);
                if (t.left != null)
                    nodes.add(t.left);
                if (t.right != null)
                    nodes.add(t.right);
                if (t.val <= root.val)
                    return false;
                nodes.remove(0);
            }
            return true;
        }
    }
/* Accepted, bad time complexity
    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        if (root.left != null)
            if (!testAllElement(1, root))
                return false;
        if (root.right != null)
            if (!testAllElement(2, root))
                return false;

        return isValidBST(root.left) && isValidBST(root.right);

    }
*/
/* use inorder traversal to solve BST problem, with all elements in increasing sequence
public boolean isValidBST(TreeNode root) {

    TreeNode pre = null;
    if (root == null)
        return true;
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.empty()){
        while (root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        if (pre != null && pre.val >= root.val)
            return false;
        pre = root;
  	    root = root.right;
    }
    return true;

}
*/
public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
}

public boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
    if (root == null) return true;
    if (root.val >= maxVal || root.val <= minVal) return false;
    return (minVal == null || root.val > minVal) && (maxVal == null || root.val < maxVal) && isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
}
}
// @lc code=end

