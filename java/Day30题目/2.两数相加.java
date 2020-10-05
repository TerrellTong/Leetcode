/*
	算法思想：
		之前做过，相当于二刷，成功做了出来！！
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
        ListNode head = new ListNode();
        ListNode tmp = head;
        ListNode h1 = l1;
        ListNode h2 = l2;
        int flag = 0;
        while(h1 != null || h2 != null){
            int r1 = h1 == null ? 0 : h1.val;
            int r2 = h2 == null ? 0 : h2.val;
            int sum = (r1+r2 + flag) % 10;
            flag = (r1+r2 + flag) / 10;
            tmp.next = new ListNode(sum);
            tmp = tmp.next;
            if(h1 != null)
                h1 = h1.next;
            if(h2 != null)
                h2 = h2.next;
        }
        if(flag != 0)
            tmp.next = new ListNode(flag);



        return head.next;
    }
}