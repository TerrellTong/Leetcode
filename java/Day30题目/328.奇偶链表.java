/*
	算法思想：
		比较经典的链表问题！不会！！！
		这个声明两个空间，还是O(1),因为是指针，直接指向了oddHead位置
		
题解： https://leetcode-cn.com/problems/odd-even-linked-list/solution/qi-ou-lian-biao-by-leetcode-solution/

		https://leetcode-cn.com/problems/odd-even-linked-list/solution/kuai-lai-wu-nao-miao-dong-qi-ou-lian-biao-by-sweet/
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
    public ListNode oddEvenList(ListNode head) {
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;

        //遍历原链表，根据isOdd标识决定插入奇链表还是偶链表
        boolean isodd = true;
        while(head != null){
            if(isodd){
                oddTail.next = head;
                oddTail = oddTail.next;
            }else{
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            //取反运算
            isodd = !isodd;
        }
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;

    }
}