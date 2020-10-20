/*
	算法思想：
		解法三，找到链表的中点，然后将链表的后半段逆转。再将逆转后的链表插入到前半段链表中！
		相当于涉及了两个算法！（链表逆置）
		
题解：https://leetcode-cn.com/problems/reorder-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-34/
		

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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;

        //使fast能够移动两个节点，移动完成后，此时slow为链表的中点
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        //将后半段的链表逆置
        newHead = reverse(newHead);

        while(newHead != null){
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return null;
        }
        ListNode tail = head;
        //原head的下一个置为head
        head = head.next;
        //将尾部置空
        tail.next = null;

        while(head != null){
            ListNode tmp = head.next;
            head.next = tail;
            //使旧的head赋值为tail
            tail = head;
            //让原来的head.next变为head
            head = tmp;
        }

        return tail;
    }
}

