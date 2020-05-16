/*
	算法思想：
		链表操作
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
    public ListNode reverseKGroup(ListNode head, int k) {
        //dummy哨兵结点(数据结构中的头结点)
        ListNode dummy = new ListNode(0),next;
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        int len = 0;
        if(head == null)
            return null;
        //计算链表的长度
        while(head != null){
            len++;
            head = head.next;
        }
        //表头重移动
        head = dummy.next;

        //i表示链表长度可以被k分成多少组
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                //用头插法可以逆序
                next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            //链表连接
            prev = curr;
            curr = prev.next;
        }
        return dummy.next;
    }
}











