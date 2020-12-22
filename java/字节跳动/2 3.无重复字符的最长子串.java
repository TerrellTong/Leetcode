/*
	算法思想：
		滑动窗口，用map，存储当前字符串上一次出现的位置,left记录窗口的最左端
		
题解：https://leetcode-cn.com/problems/reverse-nodes-in-k-group/comments/  评论区 powcai，思路三
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //用map，存储当前字符串上一次出现的位置
        Map<Character,Integer> map = new HashMap();
        //记录滑动窗口的最左边界
        int left = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
			//如果之前这个字符串出现过，我们直接把窗口移到这次出现字符的下一个
            if(map.containsKey(c)){
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            res = Math.max(res,i-left+1);
        }
        return res;
    }
}