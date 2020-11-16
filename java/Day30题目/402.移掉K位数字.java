/*
	算法思想：
		评论的题解
			从左到右，找第一个比后面大的字符，删除，清零，k次扫描
			第一次是找到一个最大的值，这个值比第一个字符大
			例如，12345 第一次删除，就删除5！
		
题解：https://leetcode-cn.com/problems/remove-k-digits/comments/
*/

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            //此时j必须为1，因为要找到第一个比后面大的字符，然后删除！
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) 
                idx = j;
            //delete(int a,int b)方法：包含两个参数，使用时删除索引从a到b（包括a不包括b）的所有字符；
            s.delete(idx, idx + 1);
			//去0
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }
}