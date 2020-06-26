/*
	算法思想：
		dfs+缓存（记忆化搜索）
	DFS思路:
		"leetcode"能否break，可以分解为："l"是否在单词表中，剩余子串能否break
		就是回溯，考察所有的可能，用指针 start 从左往右扫描 s 串
		如果指针的左侧的子串，是单词表中的单词，则对以指针为开头的剩余子串，递归考察
		比如下图遇到 "leet" 这个单词表里的单词，继续往下做
		如果指针的左侧的子串不是单词表里的，回溯，进入别的分支
	二刷！还是不会！

作者：hyj8
链接：https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        Map<Integer,Boolean> map = new HashMap();
        map.put(head.val,true);
        ListNode p = head;
        while(p.next != null){
            //当前待删除的结点
            ListNode cur = p.next;
            if(map.containsKey(cur.val)){
                //指向另一个指针
                ListNode temp = p.next;
                p.next = temp.next;
				//不能写 p=p.next;因为判断条件是p.next
            }else{
                map.put(cur.val,true);
                p = p.next;
            }
        }
        return head;
    }
}




