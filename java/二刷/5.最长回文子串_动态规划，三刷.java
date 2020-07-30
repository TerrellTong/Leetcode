/*
	算法思想：
		动态规划，第三次做，还是没想到！！！！
		还认为的是dfs!!
	
*/

class Solution {
    public String longestPalindrome(String s) {
        //获取字符串s的长度
        int len = s.length();
        if(len < 2)
            return s;
        //进行dp数组的构建
        //dp数组表示：从i到j是否是回文串
        boolean[][] dp = new boolean[len][len];

        //初始化
        for(int i=0;i<len;i++)
            dp[i][i] = true;

        //start记录最大子字符串的起始位置
        int start = 0;
        int maxLen = 1;
        //进行遍历，然后状态转移
        //什么时候进行状态转移？当两端的值想等的时候
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    //如果相等，且双指针的距离<3，则表示为回文串
                    if(j-i<3)
                        dp[i][j] = true;
                    else
                        //状态转移
                        dp[i][j] = dp[i+1][j-1];
                }else
                    dp[i][j] = false;

                //如果存在某个dp[i][j]为true,则表示s[i,j]为回文，此时进行最大长度的判断
                if(dp[i][j]){
                    int curLen = j-i+1;
                    if(curLen > maxLen){
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
    return s.substring(start,start+maxLen);
    }
}