/*
	算法思想：
		之前做过，每日一题做过，但是大致知道思想，实现还是有问题！！！！
		评论的题解
			从左到右，找第一个比后面大的字符，删除，清零，k次扫描
			第一次是找到一个最大的值，这个值比第一个字符大
			例如，12345 第一次删除，就删除5！
		
题解：https://leetcode-cn.com/problems/remove-k-digits/comments/

*/

class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length())
            return "0";

        //将num转成StringBuilder
        StringBuilder sb = new StringBuilder(num);

        for(int i=0;i<k;i++){
            int idx = 0;
            //删除递增序列中，最大的那个，如果是递减序列，则直接删除第一个
            for(int j=1;j<sb.length() && sb.charAt(j) >= sb.charAt(j-1);j++)
                idx = j;
            //StringBuilder的方法，删除a,b，包括a，不包括b
            sb.delete(idx,idx+1);
            //去0
            while(sb.length() > 1 && sb.charAt(0) == '0')
                sb.delete(0,1);
        }
        return sb.toString();
    }
}