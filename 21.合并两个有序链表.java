
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
         //����һ��ͷ���
        ListNode head = new ListNode(-1);
        //����һ��β���
        ListNode rail = new ListNode(-1);
        //ͷָ��β���
        head.next = rail;
        //��������
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
        //�������һ������һ������̵��������Ҫ�������±Ƚ���
        if(l1!= null)
            rail.next = l1;
        else if(l2!=null)
            rail.next = l2;
        return head.next.next;
    }
}

//������prev��㣬prev�����prehead�����һ���ģ�������prehead.next;

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

