/*
	算法思想：
     由于题目的时间复杂度要求 O(1)，空间肯定不能省，存取数据时间性能最好的就是哈希表，因此底层的数据结构一定是一个哈希表;
	 又由于缓存大小有限制，删除策略是「先看访问频次，再看访问时间」，所以需要记录每个数据访问的频次;
    「删除某个数据」得 O(1)，访问某个数据，时间优先级得提前（提前到当前频次最高），
	  这样的数据结构符合在头尾访问数据最快，并且删除其中一个结点也得是 O(1)O(1)，这种数据结构是「双向链表」；
    「链表」结点得记录：1、value，2、key（在哈希表里删除的时候用得上），3、访问次数信息，以便知道下一个访问次数是多少；
	                   4、前驱结点引用，5、后继结点引用；
	哈希表存储的 key 就是题目的 key，方便快速查询和删除，value 是结点的引用，方便对结点进行操作。
	可见图分析！

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/lfu-cache/solution/ha-xi-biao-shuang-xiang-lian-biao-java-by-liweiwei/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
				
*/

/*liweiwei的评论下的*/

public class LFUCache {

    /**
     * 缓存的容量
     */
    private int capacity;

    /**
     * 存放节点信息的HashTable
     * key--题目中的key
     * value--节点的引用
     */
    private Map<Integer, ListNode> cache;

    /**
     * 存放频率信息的HashTable
     * key--访问频率
     * value--双向链表
     */
    private Map<Integer, DoubleLinkedList> freqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    /**
     * get一次操作，访问次数就加1
     * 从原来的链表调整到访问次数更高的链表的表头
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // capacity可能会传入0
        if (capacity == 0) {
            return -1;
        }

        if (cache.containsKey(key)) {
            //从原来的链表中删除，返回被移除的结点
            ListNode node = removeFromList(key);
            //更新访问频率
            node.freq++;
            //挂载到新的链表上
            addIntoHead(node.freq, node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        // capacity可能会传入0
        if (capacity == 0) {
            return;
        }

        //如果key存在，就更新访问次数，更新值
        if (cache.containsKey(key)) {
            //从原来的链表中删除
            ListNode node = removeFromList(key);
            //更新值和频率
            node.val = value;
            node.freq++;
            //添加到频率更高的链表的头部
            addIntoHead(node.freq, node);
            return;
        }

        //如果key不存在并且cache满了，先删除链表里的节点，再删除cache里的节点
        if (cache.size() == capacity) {
            //从双向链表里删除
            DoubleLinkedList linkedList = freqMap.get(getMinFrequency());
            ListNode remove = linkedList.removeTail();
            //从cache里删除
            cache.remove(remove.key);
        }
        //如果key不存在并且cache未满，就放在访问次数为1的链表头部
        ListNode node = new ListNode(key, value);
        addIntoHead(1, node);
        cache.put(key, node);
    }


    /**
     * 获取最小的频率
     *
     * @return
     */
    private int getMinFrequency() {
        int minFreq = Integer.MAX_VALUE;
        Set<Integer> set = freqMap.keySet();
        for (int f : set) {
            if (freqMap.get(f).size > 0 && f < minFreq)
                minFreq = f;
        }
        return minFreq;
    }

    /**
     * 从链表中删除节点
     *
     * @param key
     * @return
     */
    private ListNode removeFromList(int key) {
        ListNode node = cache.get(key);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        freqMap.get(node.freq).size--;
        return node;
    }

    /**
     * 添加到链表的头部
     *
     * @param freq
     * @param node
     */
    private void addIntoHead(int freq, ListNode node) {
        DoubleLinkedList linkedList;
        //如果不存在新的频率的链表就初始化
        if (freqMap.containsKey(freq)) {
            linkedList = freqMap.get(freq);
        } else {
            linkedList = new DoubleLinkedList();
        }
        linkedList.addFromHead(node);
        freqMap.put(freq, linkedList);
    }

    /**
     * 节点类，双向链表的节点
     */
    private class ListNode {
        public int key;
        public int val;
        public int freq = 1;
        public ListNode pre;
        public ListNode next;

        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    /**
     * 双向链表
     * 存放具有相同访问频率的节点的集合
     * 规定：链表头部的节点是刚刚加入的，链表尾部的节点是最早加入的节点
     */
    private class DoubleLinkedList {

        /**
         * 虚拟头结点
         */
        private ListNode dummyHead;

        /**
         * 虚拟尾结点
         */
        private ListNode dummyTail;

        /**
         * 当前双向链表的有效节点个数
         */
        private int size;

        public DoubleLinkedList() {
            dummyHead = new ListNode(-1, -1);
            dummyTail = new ListNode(-1, -1);

            dummyHead.next = dummyTail;
            dummyTail.pre = dummyHead;
            size = 0;
        }


        /**
         * 在头部添加节点
         * @param node
         */
        private void addFromHead(ListNode node) {
            ListNode first = dummyHead.next;
            first.pre = node;
            node.next = first;
            node.pre = dummyHead;
            dummyHead.next = node;
            size++;
        }

        /**
         * 从链表尾部删除节点
         * @return
         */
        private ListNode removeTail() {
            if (size == 0) {
                throw new RuntimeException("DoubleLinkedList is Empty!");
            } else {
                ListNode last = dummyTail.pre;
                last.pre.next = dummyTail;
                dummyTail.pre = last.pre;
                size--;
                return last;
            }
        }
    }
}











