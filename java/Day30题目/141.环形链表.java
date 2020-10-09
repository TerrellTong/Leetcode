/*
	算法思想：
		快慢指针，好像环的题目做过
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode small = head;
        ListNode fast = head.next;
        while(fast != null){
            if(small == fast)
                return true;
            small = small.next;
            
            if(fast.next == null)
                fast = null;
            else 
                fast = fast.next.next;
        }
        return false;
    }
}