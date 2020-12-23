/*
	算法思想：
		翻转后半段，这次翻转没有用递归，之前做过，相当于第二次做ac了
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null)
            return true;
        //快慢指针，完成链表的中点
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = reverse(slow.next);
        ListNode s1 = head;
        ListNode s2 = newHead;
        while(s1 != null && s2 != null){
            if(s1.val != s2.val)
                return false;
            s1 = s1.next;
            s2 = s2.next;
        }
        return true;

    }

    public ListNode reverse(ListNode node){
        ListNode head = node;
        ListNode tail = new ListNode(0);
        while(head != null){
            ListNode tmp = head.next;
            ListNode tn = tail.next;
            head.next = null;
            tail.next = head;
            head.next = tn;
            head = tmp;
        }
        return tail.next;
    }
}