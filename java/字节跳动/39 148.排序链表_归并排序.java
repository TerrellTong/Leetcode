/*
	算法思想：
		之前做过，还是忘了！！！
		归并排序的思想！！！
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
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //后半段的头结点
        ListNode newhead = slow.next;
        slow.next = null;

        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(newhead);
        return merge(leftHead,rightHead);
    }

    public ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(leftHead != null && rightHead != null){
            if(leftHead.val <= rightHead.val){
                ListNode tmp = leftHead.next;
                leftHead.next = null;
                tail.next = leftHead;
                tail = tail.next;
                leftHead = tmp;
            }else{
                ListNode tmp = rightHead.next;
                rightHead.next = null;
                tail.next = rightHead;
                tail = tail.next;
                rightHead = tmp;
            }
        }

        if(leftHead != null)
            tail.next = leftHead;
        else
            tail.next = rightHead;
        return dummyHead.next;
    }
}