/*
	算法思想：
		在第一个结点前增加一个tmp结点，此时的两个节点交换就比较方便了！！！
		我是按照两个节点之间交换，没有想到在第一个结点前添加一个！！
		
题解：https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/hua-jie-suan-fa-24-liang-liang-jiao-huan-lian-biao/
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
    public ListNode swapPairs(ListNode head) {
        //制造一个观察节点，专门用于这个节点，后面两个节点的交换！
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode tmp = pre;
        while(tmp.next != null && tmp.next.next != null){
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;
            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }
        return pre.next;

    }
}
