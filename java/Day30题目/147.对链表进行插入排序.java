/*
	算法思想：
		怎么说呢 
			大致知道是什么要求，但是实现有点问题！ 链表类型的不熟练！！
		
		
题解：https://leetcode-cn.com/problems/insertion-sort-list/solution/988chang-gui-pai-xu-jian-dan-yi-dong-by-gu-xiong-0/
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;
        
        //pre指针，一直在链表中移动！！
        ListNode pre = head;
        ListNode cur = head.next;

        while(cur != null){
            //如果后一个节点大于等于前一个结点，就后移动
            if(cur.val >= pre.val){
                pre = pre.next;
                cur = cur.next;
                continue;
            }

            //将要比较的节点拎出来
            pre.next = cur.next;
            cur.next = null;

            //如果cur比当前头结点还小，则直接处理
            if(cur.val < head.val){
                cur.next = head;
                head = cur;
                //cur一直是pre的下一个！！！
                //cur一直是要插入的元素！！
                cur = pre.next;
                continue;
            }

            //在中间的常规插入
            ListNode c = head.next;
            ListNode p = head;
            //找到一个cur 是大于 c的位置，即需要插入
            while(cur.val > c.val){
                p = c;
                c = c.next;
            }

            cur.next = c;
            p.next = cur;
            cur = pre.next;

        }
        return head;
    }
}