/*
	算法思想：
		按照层序遍历的思想，next指向的是层序遍历的邻居！
		
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
        List<List<Node>> res = new ArrayList();
        Queue<Node> q1 = new LinkedList();
        Queue<Node> q2 = new LinkedList();
        q1.offer(root);
        if(root == null)
            return root;

        while(!q1.isEmpty() || !q2.isEmpty()){
            List<Node> list = new ArrayList();
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    Node cur = q1.poll();
                    list.add(cur);
                    if(cur.left != null)
                        q2.offer(cur.left);
                    if(cur.right != null)
                        q2.offer(cur.right);
                }
            }else{
                while(!q2.isEmpty()){
                    Node cur = q2.poll();
                    list.add(cur);
                    if(cur.left != null)
                        q1.offer(cur.left);
                    if(cur.right != null)
                        q1.offer(cur.right);
                }
            }
            res.add(new ArrayList(list));
        }

        for(List<Node> tmp : res){
            for(int i=0;i<tmp.size();i++){
                if(i == tmp.size()-1){
                    tmp.get(i).next = null;
                    continue;
                }
                tmp.get(i).next = tmp.get(i+1);
            }
        }
        return root;
    }
}