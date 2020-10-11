/*
	算法思想：
		快慢指针，好像环的题目做过
		快慢指针，都从head开始！！
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
        ListNode fast = head;
        while(fast != null){
            
            small = small.next;
            
            if(fast.next == null)
                fast = null;
            else 
                fast = fast.next.next;
                
            if(small == null)
                return false;

            if(small == fast)
                return true;
        }
        return false;
    }
}
