/*
	算法思想：
		快慢指针，快慢指针不一定要求fast是slow的两倍，可以视情况而定，思想不要僵化！！
		此时的快指针是先走n个，然后慢指针移动
		当fast为null，即slow移动到了要删除的节点！
		返回必须是tmp.next，不能是head，因为head有可能被删除了
		

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
    public ListNode removeNthFromEnd(ListNode head, int n) {    
        ListNode fast = head;
        ListNode slow = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode tmp = pre;

        while(n > 0){
            fast = fast.next;
            n--;
        }

        while(fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        //此时的slow指向的是被删除结点
        pre.next = slow.next;

        return tmp.next;
    }
}

