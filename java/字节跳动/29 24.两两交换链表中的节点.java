/*
	算法思想：
		之前做过，知道思想，没有按照之前的做，我是采用了对i进行计数为2的方法，相当于k个一组翻转链表
		
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode end = head;
        ListNode pre = dummyHead;
        int i = 1;
        while(end != null){
            if(i == 2){
                i = 1;
                ListNode tmp = pre.next;
                pre.next = end;
                tmp.next = end.next;
                end.next = tmp;
                
                pre = tmp;
                end = pre.next;
            }else{
                i++;
                end = end.next;
            }
        }
        return dummyHead.next;
    }
}