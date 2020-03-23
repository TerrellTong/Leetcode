/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
	算法思想：层次遍历
	如果用一个队列进行层次遍历，会有一个麻烦，就是不知道每一层什么时候结束，就没办法将每一层的数据分别用不同集合来存储。
	所以可以采用两个队列来实现，一个队列遍历当前层，一个队列存储下一层，交替使用，达到目的。

 */
class Solution {
    //List<List<Integer>> 表示最后返回的队列是里面还嵌套着队列
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //通过创建一个双向链表来实现队列
        //创建两个队列的目的就是一个队列用来遍历当前层，另一个队列用来保存下一层的数据
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        //将root放入q1队列中(用offer方法)
        q1.offer(root);
        while(!q1.isEmpty() || !q2.isEmpty()){
            //用res来保存当前层的结果
            List<Integer> res = new ArrayList<>();
            //如果q1不为空，那么我们就对q1进行存储当前层数据
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){  //遍历当前层
                    //用cur结点保存q1弹出的结点
                    TreeNode cur = q1.poll();
                    //将当前层的元素添加到集合中
                    res.add(cur.val);
                    //如果当前结点的左结点/右节点不为空，则添加到q2队列
                    if(cur.left != null){
                        q2.offer(cur.left);
                    }
                    if(cur.right!=null){
                        q2.offer(cur.right);
                    }
                }
        }else{
            while(!q2.isEmpty()){  //遍历当前层
                    //用cur结点保存q2弹出的结点
                    TreeNode cur = q2.poll();
                    //将当前层的元素添加到集合中
                    res.add(cur.val);
                    //如果当前结点的左结点/右节点不为空，则添加到q1队列
                    if(cur.left != null){
                        q1.offer(cur.left);
                    }
                    if(cur.right!=null){
                        q1.offer(cur.right);
                    }
                }
        }
        //将这一层的数据结果添加到结果集合中
        list.add(res);
    }
    //集合反转
	Collections.reverse(list);
    return list;
}
}