/*
	算法思想：
		递归！，滑动窗口不好实现！！！
		递归重点：我们在调用递归函数的时候，把递归函数当做普通函数（黑箱）来调用，即明白该函数的输入输出是什么，而不用管此函数内部在做什么。
		
		如果一个字符 c 在 s 中出现的次数少于 k 次，那么 s 中所有的包含 c 的子字符串都不能满足题意。
		所以，应该在 s 的所有不包含 c 的子字符串中继续寻找结果：把 s 按照 c 分割（分割后每个子串都不包含 c），得到很多子字符串 t；
		下一步要求 t 作为源字符串的时候，它的最长的满足题意的子字符串长度
		
题解：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/jie-ben-ti-bang-zhu-da-jia-li-jie-di-gui-obla/
		
*/


class Solution {
    public int longestSubstring(String s, int k) {
        //递归终止的情况
        if(s.length() < k)
            return 0;

        HashMap<Character,Integer> counter = new HashMap();
        //计算当前字符串对应的次数
        for(Character c:s.toCharArray())
            counter.put(c,counter.getOrDefault(c,0)+1);
        
        for(Character c:counter.keySet()){
            //如果当前这个字符的次数小于k，则说明其子串都不满足题意，我们直接剔除包含这个字符的子串
            if(counter.get(c) < k){
                int res = 0;
				//split函数，可以用来讲字符串以“c”进行拆分！新用法！
                for(String str:s.split(String.valueOf(c))){
                    res = Math.max(res,longestSubstring(str,k));
                }
                return res;
            }
        }
        return s.length();
        
        
    }
}