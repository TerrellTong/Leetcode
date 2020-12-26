/*
	算法思想：
		将节点取出来，然后进行堆排序！！！
		之前的递归不会！！，写了就忘
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0)
            return null;
        //声明一个堆
        PriorityQueue<ListNode> queue = new PriorityQueue(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }
        });

        for(ListNode l : lists){
            while(l != null){
                queue.add(l);
                l = l.next;
            }
        }
       
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;
        while(!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
        }
        //尾部置空
        tail.next = null;
        return dummyHead.next;
    }
}