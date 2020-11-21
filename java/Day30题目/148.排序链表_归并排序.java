/*
	算法思想：
		把昨天的插入排序写了进去，但是不是最优，要求O(nlogn)
		
		
题解：https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/（看热评）
		
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        //找链表的中点
        ListNode fastNode = head;
        ListNode slowNode = head;
        while(fastNode.next != null && fastNode.next.next != null){
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }

        //这个头结点是，中点的下一个结点
        //slowNode现在已经是中点了
        ListNode newHead = slowNode.next;
        slowNode.next = null;//两个链表拆开
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(newHead);
        return merge(leftHead,rightHead);
    }

    public ListNode merge(ListNode l1,ListNode l2){
        ListNode sentry = new ListNode(-1);
        ListNode cur = sentry;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 != null ? l1 : l2;
        return sentry.next;
    }
}