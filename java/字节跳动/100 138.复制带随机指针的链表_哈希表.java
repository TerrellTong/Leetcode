/*
	算法思想：
		将原节点和新节点进行一个映射，进行新老节点一一对应。
		map.get(原节点)，得到的就是对应的新节点
		map.get(原节点.next)，得到的就是对应的新节点.next
		map.get(原节点.random)，得到的就是对应的新节点.random

作者：wang_ni_ma
链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/solution/liang-chong-shi-xian-tu-jie-138-fu-zhi-dai-sui-ji-/   方法二！
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/


/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head== null)
            return null;

        //创建一个哈希表，key是原节点，value是新节点
        Map<Node,Node> map = new HashMap();
        Node p = head;
        //将原节点和新节点放入哈希表中
        while(p != null){
            Node newNode = new Node(p.val);
            map.put(p,newNode);
            p = p.next;
        }
        //将p重新指向头结点
        p = head;
        while(p != null){
            Node newNode = map.get(p);
            //p是原节点，map.get(p)是对应的新节点，p.next是原节点的下一个
            //map.get(p.next)是原节点下一个对应的新节点
            if(p.next != null){
                newNode.next = map.get(p.next);
            }
            //p.random是原节点的随机指向
            //map.get(p.random)是原节点的随机指向  对应新的节点
            if(p.random != null)
                newNode.random = map.get(p.random);

            p = p.next;
        }
        //返回头结点，即原点对应的value
        return map.get(head);
    }
}