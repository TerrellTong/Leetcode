/*
	算法思想：
		由于是有序数组转成二叉搜索树，
		而二叉搜索树的中序遍历就是一个递增的序列
		因此，我们的根结点就是有序数组的中点，（我们通过快慢指针来找到链表的中点）
		同理，我们用dfs，找到根结点的左右孩子结点，（此时的左右子树，也相当于要找到中点，因此我们采用对左半部分/右半部分 分别进行dfs，找到相应的根结点）
		
		我知道二叉搜索树与有序链表的关系：树的中序遍历就是有序链表！，但是不知道如果进行树的构建！
		此时只需要一个中序遍历即可构建二叉搜索树（利用二叉搜索树的特性，中点！！），而不需要先序/后序，我想的是需要先序/后序+中序才能构建
		

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        return dfs(head,null);
    }

    public TreeNode dfs(ListNode head,ListNode tail){
        if(head == tail)
            return null;
        //通过快慢指针来找到中点
        ListNode slow = head;
        ListNode fast = head;
        //如果fast.next为tail,则fast.next.next就会报异常
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        //此时的slow已经指向了链表的中点
        TreeNode root = new TreeNode(slow.val);
        root.left = dfs(head,slow);
        root.right = dfs(slow.next,tail);
        return root;
    }
}