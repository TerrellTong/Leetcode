/*
	算法思想：
		哈希表<Integer,ListNode>（考虑成功）+双向链表（未想到），双向链表的结点是自己定义的，不是直接用的LinkedList
*/
 
public class LRUCache {
    private Map<Integer,ListNode> map;
    //双链表结点
    private class ListNode{
        private Integer key;
        private Integer value;
        //前驱结点
        private ListNode pre;
        //后继结点
        private ListNode next;
        //构造函数
        public ListNode(){
        }
        public ListNode(Integer key,Integer value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    //哨兵头结点
    private ListNode dummyHead;
    //哨兵尾结点
    private ListNode dummyTail;

    public LRUCache(int capacity){
        map = new HashMap(capacity);
        this.capacity = capacity;
        dummyHead = new ListNode(-1,-1);
        dummyTail = new ListNode(-1,-1);
        //双向链表的初始化
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }

    //get方法：如果存在此结点，则将此节点移动到双向链表的头部
    public int get(int key){
        if(map.containsKey(key)){
            //通过map的key，从而获取ListNode结点
            ListNode node = map.get(key);
            int val = node.value;
            //把当前node移动到双向链表的头部
            moveNode2Head(key);
            return val;
        }else
            return -1;
    }

    //put方法:如果哈希表的容量满了，则移除链表末尾元素，并把新元素插入到链表头部
    //如果map中存在这个元素，则更新value,并将ListNode结点中的key移动到双向链表头部
    public void put(int key,int value){
        if(map.containsKey(key)){
            //更新value
            map.get(key).value = value;
            //把当前node移动到双向链表的头部
            moveNode2Head(key);
            return;
        }

        if(map.size() == capacity){
            //如果满了
            ListNode oldTail = removeTail();

            //设计ListNode结点的key就是为了在这里删除
            map.remove(oldTail.key);
        }

        //然后添加元素
        ListNode newNode = new ListNode(key,value);
        map.put(key,newNode);
        addNode2Head(newNode);
    }

    //3个公共方法
    //删除双链表尾部结点，并把原尾部结点返回
    private ListNode removeTail(){
        ListNode oldTail = dummyTail.pre;
        ListNode newTail = oldTail.pre;

        //两侧结点建立连接
        newTail.next = dummyTail;
        dummyTail.pre = newTail;

        return oldTail;
    }

    //把当前key指向的结点移动到双向链表的头部
    private void moveNode2Head(int key){
        //从map中把key的结点拿出来
        ListNode node = map.get(key);
        //把原来node的前后驱接上（记住关系）
        node.pre.next = node.next;
        node.next.pre = node.pre;

        //把node结点添加到头结点的后面
        addNode2Head(node);
    }

    //双链表头部(哨兵结点dummyHead)添加一个新结点
    private void addNode2Head(ListNode newNode){
        //当前头结点
        ListNode oldHead = dummyHead.next;

        //旧的头，前驱指向newNode
        oldHead.pre = newNode;

        //设置新结点的前驱和后继
        newNode.pre = dummyHead;
        newNode.next = oldHead;

        //dummyHead的后继结点进行修改
        dummyHead.next = newNode;
    }
}











