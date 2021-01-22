/*
	算法思想：
		注意与72的dp含义的区别！，我自己做了出来，也ac了，但是漏掉了左上角的值，即同时删除！！
	
题解：https://leetcode-cn.com/problems/delete-operation-for-two-strings/solution/583-liang-ge-zi-fu-chuan-de-shan-chu-cao-vzd9/
	
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //dp数组的含义：以i位置为终止与以j位置为终止的相同所需要删除的最小步数
        int[][] dp = new int [len1+1][len2+1];
        //base case
        for(int i=0;i<=len1;i++)
            dp[i][0] = i;
        for(int j=0;j<=len2;j++)
            dp[0][j] = j;

        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
                //相等，不需要删除
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    //不仅s1可删除，s2也可以删除，注意dp[i][j-1]与72题的含义！！，72是只能s1进行操作
                    //还会出现s1,s2同时删除的情况！！ 我漏掉了
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1])+1 , dp[i-1][j-1]+2);
            }
        
        return dp[len1][len2];
    }
}