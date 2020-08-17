/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (34.30%)
 * Likes:    3980
 * Dislikes: 304
 * Total Accepted:    388.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
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
    // int left_max = Integer.MIN_VALUE;
    // int right_max = Integer.MIN_VALUE;
    // int rootpath;
    
    // public static int maxDepth(TreeNode root){
    //     if (root == null)
    //         return 0;
    //     return Math.max(Math.max(maxDepth(root.left), maxDepth(root.right)) + root.val, root.val);
    // }

    // public static int maxRootSum(TreeNode root){
    //     int left, right;
    //     if (root == null)
    //         return 0;
    //     left = maxDepth(root.left);
    //     right = maxDepth(root.right);
    //     if (left < 0 && right < 0)
    //         return root.val;
    //     else if (left >= 0 && right < 0)
    //         return left + root.val;
    //     else if (left < 0 && right >= 0)
    //         return root.val + right;
    //     else 
    //         return left + root.val + right;
    // }

    
    // public int maxPathSum(TreeNode root) {
    //     if (root == null)
    //         return Integer.MIN_VALUE;
    //     left_max = Math.max(maxPathSum(root.left), left_max);
    //     right_max = Math.max(maxPathSum(root.right), right_max);
    //     rootpath = maxRootSum(root);
    //     if (rootpath > left_max && rootpath > right_max)
    //         return rootpath;
    //     else 
    //         return Math.max(left_max, right_max);
            
    // }        //Accepted, bad time complexity



    int maxValue = Integer.MIN_VALUE;
    int left, right;

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        maxPath(root);
        return maxValue;
    }

    private int maxPath(TreeNode root){
        if (root == null)
            return 0;
        int left = Math.max(maxPath(root.left), 0);
        int right = Math.max(maxPath(root.right), 0);
        maxValue =  Math.max(maxValue, left + right + root.val);
        // 用一个全局变量存储最大值，而函数的返回值可以为递归需要计算的值
        return  Math.max(left, right) + root.val;   // 返回的是由根到叶子路径上的最大值
    } 
}
// @lc code=end

