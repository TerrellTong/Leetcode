/*
	算法思想：
		滑动窗口
*/
 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //用set当成滑动窗口
        Set<Character> set = new HashSet();
        int n = s.length();
        //串起始位置
        int start = 0;
        //记录结果
        int res = 0;
        int i = 0;
        while(i<n){
            //如果set不包含这个字符，则加入set，从而判断最长字符串，并滑动窗口右指针移动
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i++));
                res = Math.max(res,i-start);
            }else{
                //滑动窗口移动,将左边的字符从滑动窗口移出去
                set.remove(s.charAt(start));
                start++;
            }
        }
        return res;
    }
}












