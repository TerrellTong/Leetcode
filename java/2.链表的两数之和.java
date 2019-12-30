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
       int sum,flag=0;
	   //构造一个头结点，用来指向下一个
        ListNode headNode = new ListNode(-1);
        ListNode resultNode = new ListNode(-1) ;
        headNode.next = resultNode;
        while(l1!=null||l2!=null){
			//如果当前节点为空，则默认此时的val为0，这样就不会报空指针异常了！
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            sum = x+y+flag;
            flag = sum/10;
            resultNode.next = new ListNode(sum%10);
            resultNode = resultNode.next;
			//存在链表一个长一个短的情况
            if(l1!=null)
                l1=l1.next;
            if(l2!=null)
                l2=l2.next;
        }
		//两个一位数相加进位的情况变成一个二位数
        if(flag==1){
            resultNode.next = new ListNode(1);
        }
        return headNode.next.next;
 }
}