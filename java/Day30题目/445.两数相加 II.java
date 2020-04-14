/*
	算法思想：
	  由于要进行逆序处理，则要使用栈的思想！！！！！！
				
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建两个栈
        Stack<Integer> s1 = new Stack();
        Stack<Integer> s2 = new Stack();
        //入栈
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        //出栈进行相加，然后用头插法插入链表
        ListNode result = null;
        int flag = 0;
        //如果s1不为空，s2不为空或者进位标志为1 就进行循环
        while(!s1.isEmpty() || !s2.isEmpty() || flag != 0){
            //如果某个栈为空则返回值为0
            int m = s1.isEmpty() ? 0 : s1.pop();
			int n = s2.isEmpty() ? 0 : s2.pop();
            int r = m+n+flag;
            flag = (r>=10)? 1 : 0;
            //进位的处理
            r = r%10;
            ListNode l = new ListNode(r);
            //头插法（没有头结点，直接从第一个结点前面进行添加）
            l.next = result;
            result = l;
        }
        return result;
    }
}











