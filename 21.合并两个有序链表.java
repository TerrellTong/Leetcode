
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         //构建一个头结点
        ListNode head = new ListNode(-1);
        //构建一个尾结点
        ListNode rail = new ListNode(-1);
        //头指向尾结点
        head.next = rail;
        //两个链表
        while(l1!=null&&l2!=null){
            if(l1.val <= l2.val){
                rail.next = new ListNode(l1.val);
                rail = rail.next;
                l1 = l1.next;
            }else{
                rail.next = new ListNode(l2.val);
                rail = rail.next;
                l2 = l2.next;
            }
        }
        //如果存在一个链表长一个链表短的情况，就要进行如下比较了
        if(l1!= null)
            rail.next = l1;
        else if(l2!=null)
            rail.next = l2;
        return head.next.next;
    }
}

//操作用prev结点，prev结点与prehead结点是一样的，返回用prehead.next;

public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // maintain an unchanging reference to node ahead of the return node.
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // exactly one of l1 and l2 can be non-null at this point, so connect
        // the non-null list to the end of the merged list.
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

