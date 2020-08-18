/*
	算法思想：
		深度优先搜索，图的深度优先搜索还是第一次遇见！！！
		https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
	
*/


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //哈希表用于存储所有被访问和克隆的节点，key是原始图中的节点，value是克隆图中的对应节点
    private HashMap<Node,Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        //如果该节点被访问过，则直接从hash表中取出对应的克隆结点返回
        if(visited.containsKey(node))
            return visited.get(node);
        
        //克隆节点，注意到为了深拷贝，我们不会克隆它的邻居列表
        Node cloneNode = new Node(node.val,new ArrayList());
        //哈希表存储克隆节点
        visited.put(node,cloneNode);

        //遍历该节点的邻居，并更新克隆节点的邻居列表
        for(Node neighbor: node.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
        
    }
}