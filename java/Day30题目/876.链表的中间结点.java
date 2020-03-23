/*
	算法思想：
		朴素法
*/
class Solution {
    public ListNode middleNode(ListNode head) {
       //遍历所有的结点，获取List的长度
       int length=0;
       ListNode h = head;
       while(h != null){
           length++;
           h = h.next; 
       } 
       int result = length/2 + 1 ;
       h = head;
       for(int i=1;i<result;i++){
           h = h.next;
       }
       return h;
    }
}

/*
	算法思想：
		快慢指针，慢指针走一步，快指针走两步，快指针到头时，慢指针就指向了链表中点
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

