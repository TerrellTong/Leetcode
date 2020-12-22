/*
	算法思想：
		哈希表<Integer,ListNode>（考虑成功）+双向链表（想到了），我是按照队列的思想，但是就是get()后将其移到队列尾部不会，我们要自己申明一个双链表节点！！！
		之前做过！
		

*/

class LRUCache {
    Map<Integer,ListNode> map;
    //双链表节点的设置
    class ListNode{
        Integer key;
        Integer value;
        //前驱节点
        ListNode pre;
        //后继节点
        ListNode next;
        //构造函数
        public ListNode(){

        }
        public ListNode(Integer key,Integer value){
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    //双向链表的头尾结点声明
    ListNode dummyHead;
    ListNode dummyTail;
    public LRUCache(int capacity) {
        map = new HashMap(capacity);
        this.capacity = capacity;
        dummyHead = new ListNode();
        dummyTail = new ListNode();
        //双向链表的初始化
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            //通过map的key，从而获取ListNode节点
            ListNode node = map.get(key);
            int val = node.value;
            //将当前结点移动到链表的头部
            moveNode2Head(key);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            //直接更新
            map.get(key).value = value;
            moveNode2Head(key);
            return;
        }

        if(map.size() == capacity){  
            //此时缓存满了，移除队尾元素
            ListNode oldTail = removeTail();
            map.remove(oldTail.key);
        }

        //将要添加的元素放到头部
        ListNode newNode = new ListNode(key,value);
        addNode2Head(newNode);
        map.put(key,newNode);
    }

    public void moveNode2Head(int key){
        ListNode node = map.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        addNode2Head(node);
    }

    public void addNode2Head(ListNode node){
        ListNode oldHead = dummyHead.next;
        node.next = oldHead;
        node.pre = dummyHead;
        dummyHead.next = node;
        oldHead.pre = node;
    }

    public ListNode removeTail(){
        ListNode tail = dummyTail.pre;
        tail.pre.next = dummyTail;
        dummyTail.pre = tail.pre;
        return tail;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */