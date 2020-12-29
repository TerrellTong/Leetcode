/*
	算法思想：
		动态规划，III和IV可以归为一类！！将k=3放到III中即可！
		
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;
        int flag = 0;
        ListNode newHead = new ListNode();
        ListNode tail = newHead;
        while(t1 != null || t2 != null){
            int c1 = t1 == null ? 0 : t1.val;
            int c2 = t2 == null ? 0 : t2.val;
            int sum = c1 + c2 + flag;
            flag = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            if(t1!=null && t1.next != null)
                t1 = t1.next;
            else
                t1 = null;

            if(t2!=null && t2.next != null)
                t2 = t2.next;
            else
                t2 = null;
        }
        if(flag != 0)
            tail.next = new ListNode(1);
        return newHead.next;
    }
}