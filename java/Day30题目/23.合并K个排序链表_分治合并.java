/*
	算法思想：
		分治合并思想，将k分成n个双链，双链再合并，然后最后再统一合并
*/
 

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            return null;
        return merge(0,lists.length-1,lists);
    }

    public ListNode merge(int start,int end,ListNode[] lists){
        //如果start == end 就直接返回此链表
        if (start == end) {
            return lists[start];
        }
        int mid = start + (end-start)/2;
        //从mid的左边分治,包括mid
        ListNode l1 = merge(start , mid,lists);
        ListNode l2 = merge(mid+1 , end,lists);
        return merge2Lists(l1,l2);
    }

    public ListNode merge2Lists(ListNode l1,ListNode l2){
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;   
        }
        if(l1 != null)
            tail.next = l1;
        if(l2 != null)
            tail.next = l2;
        return head.next;
    }
}












