/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 *
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 *
 * algorithms
 * Medium (48.26%)
 * Likes:    2350
 * Dislikes: 103
 * Total Accepted:    397K
 * Total Submissions: 820.9K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given a binary tree, return the zigzag level order traversal of its nodes'
 * values. (ie, from left to right, then right to left for the next level and
 * alternate between).
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
 * return its zigzag level order traversal as:
 * 
 * [
 * ⁠ [3],
 * ⁠ [20,9],
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
    Stack<TreeNode> stack = new Stack<>();
    Stack<TreeNode> stack1 = new Stack<>();
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean flag = true;
        TreeNode t;
        int length;
        ArrayList<Integer> level;
        if (root == null)
            return list;
        stack.push(root);
        while (!stack.empty() || !stack1.empty()){
            if(flag){
                length = stack.size();
                level = new ArrayList<>();
                while (length-- != 0){
                    t = stack.pop();
                    level.add(t.val);
                    if (t.left != null)
                        stack1.push(t.left);
                    if (t.right != null)
                        stack1.push(t.right);
                }
                list.add(level);
                flag = false;
            }else{
                length = stack1.size();
                level = new ArrayList<>();
                while (length-- !=0){
                    t = stack1.pop();
                    level.add(t.val);
                    if (t.right != null)
                        stack.push(t.right);
                    if (t.left != null)
                        stack.push(t.left);
                }
                list.add(level);
                flag = true;
            }
        }

        return list;
    }
}
// @lc code=end

