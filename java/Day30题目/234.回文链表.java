/*
	算法思想：
		快慢指针，然后逆转后一段链表，类似于之前交错链表的实现思路！
		
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
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //此时的slow已经到达链表的中点
        ListNode newHead = slow.next;
        slow.next = null;

        //逆转后半段链表
        newHead = reverseList(newHead);

        while(newHead != null){
            if(newHead.val != head.val)
                return false;
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverseList(ListNode head){
        if(head == null)
            return null;
        ListNode tail = head;
        head = head.next;
        tail.next = null;

        while(head != null){
            ListNode tmp = head.next;
            head.next = tail;
            tail = head;
            head = tmp;
        }

        return tail;
    }
}
