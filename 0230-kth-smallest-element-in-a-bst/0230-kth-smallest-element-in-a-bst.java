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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();    
        st.push(root);
        while(!st.empty()){
            while(root!=null && root.left!=null){
                st.push(root.left);
                root = root.left;
            }
            root = st.pop();
            k--;
            if(k==0) break;
            if(root.right != null){                
                st.push(root.right);                
            }                       
            root = root.right;  
        }
        return root.val;
    }
}