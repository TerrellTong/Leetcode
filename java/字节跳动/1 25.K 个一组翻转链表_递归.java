/*
	算法思想：
		递归！
		
题解：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/comments/  评论区 powcai，思路三
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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        int count = 0;
        while(cur != null && count != k){
            cur = cur.next;
            count++;
        }
        //此时的cur指向的是下一段的头结点
        if(count == k){
            //通过递归，一直找到最后一段的头结点
            cur = reverseKGroup(cur,k);
            while(count != 0){
                count--;
                ListNode tmp = head.next;
                head.next = cur;
                cur = head;
                head = tmp;
            }
            head = cur;
        }
        return head;
    }
}