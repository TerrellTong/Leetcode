/*
	算法思想：
		快慢思想，
		第一次：快指针比慢指针快一步，即慢指针走n步，快指针走2n步
		当第一次相遇时，fast置为头部，然后fast和slow都只移动一步
		

这类链表题目一般都是使用双指针法解决的，例如寻找距离尾部第K个节点、寻找环入口、寻找公共尾部入口等。

https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
	
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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head,slow = head;
        while(true){
            //如果fast.next为null，则说明无环
            if(fast == null || fast.next == null)
                return null;
            fast = fast.next.next;
            slow = slow.next;
            //第一次相遇
            if(fast == slow)
                break;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}

//自己完成的（用map）
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //用一个map存位置和ListNode
        Map<ListNode,Integer> map = new HashMap();
        ListNode p = head;
        int i=0;
        while(p != null){
            if(map.get(p) == null)
                map.put(p,i);
            else
                return p;
            p = p.next;
        }
        return null;
    }
}









