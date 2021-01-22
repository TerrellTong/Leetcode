/*
	算法思想：
		与583思路类似，只是dp数组的值变成了ASCII码了！
	
	
*/

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        //dp数组的含义：以i位置为终止与以j位置为终止的最小删除he
        int[][] dp = new int [len1+1][len2+1];
        //base case
        for(int i=1;i<=len1;i++)
            dp[i][0] = dp[i-1][0] + (int)s1.charAt(i-1);
        for(int j=1;j<=len2;j++)
            dp[0][j] = dp[0][j-1] + (int)s2.charAt(j-1);

        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
                //相等，不需要删除
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    //不仅s1可删除，s2也可以删除，注意dp[i][j-1]与72题的含义！！，72是只能s1进行操作
                    //还会出现s1,s2同时删除的情况！！ 我漏掉了
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+(int)s1.charAt(i-1),dp[i][j-1]+(int)s2.charAt(j-1)) , dp[i-1][j-1]+(int)s1.charAt(i-1)+(int)s2.charAt(j-1));
            }
        
        return dp[len1][len2];
    }
}