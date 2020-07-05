/*
	算法思想：
		类似 最长公共子串，最长公共子序列，编辑距离 等 求 2 个字符串(或数组)之间的某种关系的题目，
		一般来说都是有动态规划的解法的。
		
https://leetcode-cn.com/problems/wildcard-matching/solution/zi-fu-chuan-dong-tai-gui-hua-bi-xu-miao-dong-by-sw/
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int len1 = p.length(),len2 = s.length();
        //p是字符模式，s是字符串
        //dp数组，表示 p 的前 i 个字符和 s 的前 j 个字符是否匹配。
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len1;i++){
            if(p.charAt(i-1) != '*')
                break;
            dp[i][0] = true;
        }

        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
                if((p.charAt(i-1) == s.charAt(j-1)) || (p.charAt(i-1) == '?'))
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(i-1) == '*')
                    dp[i][j] = dp[i-1][j] | dp[i][j-1];
            }
        return dp[len1][len2];
    }
}
    





