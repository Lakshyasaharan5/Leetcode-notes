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
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        sb.append("["+root.val + "]");
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
                sb.append("["+curr.left.val+"]");
            } else {
                sb.append("[#]");
            }
            if (curr.right != null) {
                queue.offer(curr.right);
                sb.append("["+curr.right.val+"]");
            } else {
                sb.append("[#]");
            }
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }

    /**
            [100][2][3][#][#][4][5][#][#][#][#]
                  i
            q = []
            100
    */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        int i = 1;
        StringBuilder value = new StringBuilder();
        while (data.charAt(i) != ']') {
            value.append(data.charAt(i));
            i++;
        }
        i += 2;
        TreeNode root = new TreeNode(Integer.parseInt(value.toString()));
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                // [100][2][3][#][#][4]
                //          i
                String number = "";

                // left
                if (data.charAt(i) == '#') {
                    i += 3;
                } else {
                    while (data.charAt(i) != ']') {
                        number += data.charAt(i);
                        i++;
                    }
                    curr.left = new TreeNode(Integer.parseInt(number));
                    queue.offer(curr.left);
                    i += 2;
                }

                // right
                number = "";
                if (data.charAt(i) == '#') {
                    i += 3;
                } else {
                    while (data.charAt(i) != ']') {
                        number += data.charAt(i);
                        i++;
                    }
                    curr.right = new TreeNode(Integer.parseInt(number));
                    queue.offer(curr.right);
                    i += 2;
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));