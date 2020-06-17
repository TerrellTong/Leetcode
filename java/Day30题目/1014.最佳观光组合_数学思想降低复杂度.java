/*
	算法思想：
		先序遍历(Dfs的思想)
	
*/
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
        return rserialize(root,"");
    }
    //DFS深度优先遍历（先序遍历）
    public String rserialize(TreeNode root,String str){
        //特殊情况，遇到空结点返回None
        if(root == null)
            str += "None,";
        else{
            //输出根
            str += str.valueOf(root.val)+",";
            //遍历左子树
            str = rserialize(root.left,str);
            //遍历右子树
            str = rserialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //将序列化的字符串进行切割
        String[] data_array = data.split(",");
        List<String> data_list = new LinkedList(Arrays.asList(data_array));
        return rdeserialize(data_list);
    }

    //反序列化（递归）
    public TreeNode rdeserialize(List l){
        //如果当前元素是none,则为空树
        if(l.get(0).equals("None")){
            l.remove(0);
            return null;
        }

        //由于之间序列化，按住的是先序遍历的规则，因此按照先解析这棵树的左子树，然后再解析右子树的规则
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



