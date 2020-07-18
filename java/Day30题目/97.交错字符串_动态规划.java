/*
	算法思想：
		动态规划，可以转换成路径问题II,转移方程大致类似，只是添加了一下条件
		
https://leetcode-cn.com/problems/interleaving-string/solution/lei-si-lu-jing-wen-ti-zhao-zhun-zhuang-tai-fang-ch/
*/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n = s2.length();
        if(s3.length() != m+n)
            return false;
        //动态规划，dp[i][j]表示s1前i个能与s2前j个字符组成s3前i+j个字符
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        //边界初始化
        //因为dp数组是[m+1][n+1]，因此循环可以取到i=m和j=n
		//i-1，防止越界
        for(int i=1;i<=m && s1.charAt(i-1) == s3.charAt(i-1);i++)
            dp[i][0] = true;
        for(int j=1;j<=n && s2.charAt(j-1) == s3.charAt(j-1);j++)
            dp[0][j] = true;
        //状态转移，该点可以由左边/上边转移下来，并且要额外的进行位置字符的比较
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++){
                dp[i][j] = (dp[i-1][j] && s3.charAt(i+j-1) == s1.charAt(i-1))
                    || (dp[i][j-1] && s3.charAt(i+j-1) == s2.charAt(j-1));
            }
        return dp[m][n];
    }
}





