/*
 * @lc app=leetcode id=297 lang=java
 *
 * [297] Serialize and Deserialize Binary Tree
 *
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (47.43%)
 * Likes:    3202
 * Dislikes: 155
 * Total Accepted:    341.7K
 * Total Submissions: 718.5K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no
 * restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and
 * this string can be deserialized to the original tree structure.
 * 
 * Example: 
 * 
 * 
 * You may serialize the following tree:
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * as "[1,2,3,null,null,4,5]"
 * 
 * 
 * Clarification: The above format is the same as how LeetCode serializes a
 * binary tree. You do not necessarily need to follow this format, so please be
 * creative and come up with different approaches yourself.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private int getDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }
   
       // Encodes a tree to a single string.
       // order by level
/*       public String serialize(TreeNode root) {
           if (root == null)
               return "";
           LinkedList<TreeNode> queue = new LinkedList<>();
           StringBuffer buffer = new StringBuffer();
           TreeNode node;
           queue.offer(root);
           int depth = getDepth(root);
           int levelLength;
           while (depth-- > 0){
               levelLength = queue.size();
               while (levelLength-- > 0){
                   node = queue.poll();
                   if (node == null)
                       buffer.append("null");
                   else
                       buffer.append(node.val);
                   buffer.append(",");
                   if (depth > 0) {
                       if (node == null) {
                           queue.add(null);
                           queue.add(null);
                       } else {
                           queue.add(node.left);
                           queue.add(node.right);
                       }
                   }
               }
           }
           buffer.deleteCharAt(buffer.length() - 1);
           return buffer.toString();
       }*/

       // Encodes a tree to a single string.
       // preorder sequence
        // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuffer string = new StringBuffer();
        serialHelper(root, string);
        return string.toString();
    }
    private void serialHelper(TreeNode root, StringBuffer string){
        if (root == null) {
            string.append("#").append(",");
            return;
        }
        string.append(root.val).append(",");
        serialHelper(root.left, string);
        serialHelper(root.right, string);
    }
/*
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        StringBuffer buffer = new StringBuffer(data);
        TreeNode node;
        if (data.isEmpty())
            return null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        values.addAll(Arrays.asList(data.split(",")));
        System.out.println(values);
        int i = 0;
        for (i = 0; i < values.size(); i++){
            if (values.get(i).equals("null"))
                nodes.add(null);
            else
                nodes.add(new TreeNode(Integer.parseInt(values.get(i))));
        }
        System.out.println(nodes);
        for (i = 0; i < nodes.size()/2; i++){
            if (nodes.get(i) == null)
                continue;
            if (nodes.get(i) != null) {
                nodes.get(i).left = nodes.get(2 * i + 1);
                nodes.get(i).right = nodes.get(2 * i + 2);
            }
        }
        return nodes.get(0);
    }

 */
    // pre-order
    public TreeNode deserialize(String data) {
        StringBuffer buffer = new StringBuffer(data);
        TreeNode node;
        if (data.isEmpty())
            return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));

        return deserialHelper(queue);
    }

    public TreeNode deserialHelper(Queue<String> values){
        String value = values.poll();
        if (value.equals("#"))
            return null;
        return new TreeNode(Integer.parseInt(value), deserialHelper(values), deserialHelper(values));

    }
       
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end

