/*
	算法思想：
		自己ac了，可以优化，按照别人的法案

作者：sdwwld
链接：https://leetcode-cn.com/problems/rotate-list/solution/61-xuan-zhuan-lian-biao-tu-wen-xiang-jie-by-sdwwld/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

//别人的实现，直接先构成环，然后让slow移动
public ListNode rotateRight(ListNode head, int k) {
    if (head == null)
        return head;
    ListNode fast = head, slow = head;
    //链表的长度
    int len = 1;
    //统计链表的长度，顺便找到链表的尾结点
    while (fast.next != null) {
        len++;
        fast = fast.next;
    }
    //首尾相连，先构成环
    fast.next = head;
    //慢指针移动的步数
    int step = len - k % len;
    //移动步数，这里大于1实际上是少移了一步
    while (step-- > 1) {
        slow = slow.next;
    }
    //temp就是需要返回的结点
    ListNode temp = slow.next;
    //因为链表是环形的，slow就相当于尾结点了，
    //直接让他的next等于空
    slow.next = null;
    return temp;
}


//自己的实现
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0)
            return head;
        int len = 0;
        ListNode cur = head;
        //计算链表的长度
        while(cur != null){
            len++;
            cur = cur.next;  
        }
        //翻转的刚好是整数
        if(k % len == 0)
            return head;

        //移动的步数
        int count = k % len;

        //定义两个指针，让slow指向新的头结点
        ListNode slow = head;
        ListNode fast = head;
        int index = 0;
        while(index != count){
            fast = fast.next;
            index++;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        //此时slow为新节点的头部,由dummyHead指向
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        dummyHead.next = slow;
        while(tail.next != null){
            tail = tail.next;
        }
        while(head != null){
            if(head.next == slow){
                head.next = null;
            }
            tail.next = head;
            tail = head;
            head = head.next;
        }
        return dummyHead.next;
    }
}