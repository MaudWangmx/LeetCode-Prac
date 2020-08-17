/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (54.52%)
 * Likes:    3254
 * Dislikes: 78
 * Total Accepted:    641.8K
 * Total Submissions: 1.2M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * 
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 
 * 
 * return its level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [9,20],
 * ⁠ [15,7]
 * ]
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
    ArrayList<List<Integer>> list = new ArrayList<>();
    ArrayList<TreeNode> nodes = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return list;
        nodes.add(root);
        int length;
        while (!nodes.isEmpty()){
            length = nodes.size();
            ArrayList<Integer> level = new ArrayList<>();
            
            for (int i = 0; i < length; i++){
                if (nodes.get(0).left != null)
                    nodes.add(nodes.get(0).left);
                if (nodes.get(0).right != null) 
                    nodes.add(nodes.get(0).right);
    
                level.add(nodes.get(0).val);
                nodes.remove(0);

            }
            if (!level.isEmpty())
                list.add(level);
        }
        return list;
    }
}
// @lc code=end

