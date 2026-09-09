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

        StringBuilder sb = new StringBuilder(); 

        serializeHelper(root , sb); 
        
        return sb.toString(); 
    }
    private void serializeHelper( TreeNode root , StringBuilder sb){
        if (root == null) {
        sb.append("#,");
        return;
        }
        sb.append(root.val).append(","); 

        serializeHelper(root.left , sb);
        serializeHelper(root.right , sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split(","); 
        int[] index = {0}; 

        return deserializeHelper( nodes , index); 
    }
    private TreeNode deserializeHelper(String[] nodes, int[] index){
        if (nodes[index[0]].equals("#")){
            index[0]++ ; 
            return null ; 
        }

        TreeNode node = new TreeNode(Integer.parseInt(nodes[index[0]])); 
        index[0]++ ; 

        node.left = deserializeHelper(nodes, index);
        node.right = deserializeHelper(nodes, index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));