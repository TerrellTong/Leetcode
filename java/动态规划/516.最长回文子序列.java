/*
	算法思想：
		回文串属于特殊的需要二维dp解决的！！（labuladong！）

*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        //在子串s[i...j]中，最长回文的子串是dp[i][j]
        //特例！
        int[][] dp = new int [len][len];

        //base case ：只有一个字符的时候就初始化为1！！
        for(int i=0;i<len;i++)
            dp[i][i] = 1;

        for(int i = len-1;i>=0;i--)
            for(int j=i+1;j<len;j++){
				//如果当前字符相等，则最长回文长度+2
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
					//否则，当前回文串判断s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长？
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
		//此时要找的值是右上角！！！
        return dp[0][len-1];
    }
}