/*
	算法思想：
		滑动窗口的思想，我是按照labuladong的思想，但是不知道什么时候窗口停止扩大，以及我们要的结果应该放在哪？（不能套模板（直接放while），我们要依据题意）
		
题解：https://leetcode-cn.com/problems/get-equal-substrings-within-budget/comments/ Amazingt
*/


class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        //左右边界
        int left = 0,right = 0;
        int count = 0;
        int maxsize = 0;
        while(right < s.length()){
            //窗口移动
            count += Math.abs(s.charAt(right)-t.charAt(right));
            right++;

            //窗口暂停扩大，开始移动left，缩小窗口，知道count <= maxCost
            while(count > maxCost){
                //更新数据
                count -= Math.abs(s.charAt(left)-t.charAt(left));
                left++; 
            }
            //此时count <= maxcount ，则就是我们要求的最长字符
            maxsize = Math.max(right-left,maxsize);     
        }
        return maxsize;
    }
}