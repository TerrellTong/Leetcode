/*
	算法思想：
		hard的回文串，字符串翻转后进行相应的查找
		
*/


class Solution {
    public String shortestPalindrome(String s) {
        //进行字符串的翻转
        String rs = new StringBuilder(s).reverse().toString();

        for(int i=s.length();i>=0;i--){
            String s1 = s.substring(0,i);
            //一个参数，说明beginIndex为s.length()-i,直到字符串结束
            String s2 = rs.substring(s.length()-i);
            //如果两个截取之后的字符串是相等的，说明此时差不多找到了回文串
            if(s1.equals(s2))
                //只需要将rs前面的字符串添加到s即可
                return rs.substring(0,s.length()-i)+s;
        }
        return "";
    }
}