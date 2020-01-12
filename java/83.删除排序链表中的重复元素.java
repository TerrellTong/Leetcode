/*
	思想：
		直接判断链表的下一个结点和此结点是否相同
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = head;
        while(pre != null && pre.next != null){
            if(pre.val == pre.next.val){
                pre.next = pre.next.next;
            }else {
               pre = pre.next;
            }
        }
        return head;
    }
}



