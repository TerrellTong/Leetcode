/*
	算法思想：
		两个指针，当一个指针指到头，我们就换到另一个链表的头结点
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode sA = headA;
        ListNode sB = headB;
        while(sA != sB){
            if(sA == null)
                sA = headB;
            else
                sA = sA.next;
            if(sB == null)
                sB = headA;
            else
                sB = sB.next;
        }
        return sA;
    }
}