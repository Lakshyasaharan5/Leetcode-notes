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
    int result = 0;
    public int goodNodes(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        dfs(root, st);
        return result;
    }

    void dfs(TreeNode root, Stack<TreeNode> st){
        if(root == null) 
            return;

        if(root.val >= st.peek().val){
            st.push(root);
            result++;
        }
        dfs(root.left, st);
        dfs(root.right, st);
        if(root == st.peek()){
            st.pop();
        }
    }



}