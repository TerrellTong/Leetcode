/*
	算法思想：
	 滑动窗口，对于字符串的滑动窗口用set进行滑动，而不是用数组；
	 因为set对于处理字符串有个contain方法，方便使用。
	 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合
				
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
		//用set进行滑动窗口的存储，i是左边界，j是右边界
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // 不包含字符就j++（右移）
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
				//将滑动窗口的大小与ans进行比较
                ans = Math.max(ans, j - i);
            }
			//包含字符就i++（左移）
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}










