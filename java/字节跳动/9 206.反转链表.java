/*
	算法思想：
		递归，自己ac了
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
    ListNode dummyHead = new ListNode(0);
    ListNode newHead = dummyHead;
    public ListNode reverseList(ListNode head) {
        dfs(head);  
        //删除环，如果不写会出现两边循环
        newHead.next = null;
        return dummyHead.next;
    }

    public void dfs(ListNode node){
        if(node == null)
            return;
        dfs(node.next);
        newHead.next = node;
        newHead = node;
    }
}