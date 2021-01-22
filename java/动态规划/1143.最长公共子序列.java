/*
	算法思想：
		画出表格，找到终止条件，然后for循环！
	
题解：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetcode/
	
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        //dp数组表示以i结尾，j结尾的最长公共子序列的值
        int[][] dp = new int[len1+1][len2+1];

        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
				//i-1,j-1 与编辑距离同样的道理！
                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    //如果字符不相等，则找dp[i-1][j],dp[i][j-1]中的最大值，此时是不能包括当前字符的！
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }

        return dp[len1][len2];
    }
}