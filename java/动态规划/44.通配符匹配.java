/*
	算法思想：
		与正则表达式的*不同！！正则的*是匹配多个前一个元素
		与正则的思维类似！
		
题解：https://leetcode-cn.com/problems/wildcard-matching/solution/zi-fu-chuan-dong-tai-gui-hua-bi-xu-miao-dong-by-sw/
*/


class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        //base case
        //字符串长度为0，则返回true
        dp[0][0] = true;
        //由于*可以匹配0个
        for(int j=1;j<=p.length();j++){
            if(p.charAt(j-1) != '*')
                break;
            dp[0][j] = true;
        }
            


        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++){
                if(s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    //此时的*与正则表达式的*不同！！正则的*是匹配多个前一个元素
                    if(p.charAt(j-1) == '?')
                        dp[i][j] = dp[i-1][j-1];
                    if(p.charAt(j-1) == '*'){
                        //匹配0个(去掉*)/多个
                        dp[i][j] = dp[i-1][j] || dp[i][j-1];
                    }
                }
            }

        return dp[s.length()][p.length()];

    }
}