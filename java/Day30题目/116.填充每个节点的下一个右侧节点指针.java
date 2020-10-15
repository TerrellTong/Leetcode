/*
	算法思想：
		node.left 的 next 为 node.right
		node.right 的 next 为 node.next.left   可以画图理解！
		
题解：https://leetcode-cn.com/problems/find-common-characters/solution/1002cha-zhao-chang-yong-zi-fu-by-111-101/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        dfs(root,null);
        return root;
    }

    public void dfs(Node root,Node next){
        if(root != null){
            root.next = next;
            dfs(root.left,root.right);
            dfs(root.right,root.next != null ? root.next.left : null);
        }
    }
}
