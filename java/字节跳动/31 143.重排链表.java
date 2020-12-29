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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时slow.next为后半段的开头指针
        //翻转后半段
        ListNode after_node = reverse(slow.next);
        slow.next = null;

        slow = head;
        //将后半段的头结点依次插入
        while(slow != null && after_node != null){
            ListNode tmp = slow.next;
            ListNode a_tmp = after_node.next;
            slow.next = after_node;
            after_node.next = tmp;
            after_node = a_tmp;
            slow = tmp;
        }
        
    }

    public ListNode reverse(ListNode head){
        ListNode newHead = new ListNode();
        while(head != null){
            ListNode tmp = head.next;
            head.next = null;
            ListNode oldHead = newHead.next;
            newHead.next = head;
            head.next = oldHead;
            oldHead = head;
            head = tmp;
        }
        return newHead.next;
    }
}