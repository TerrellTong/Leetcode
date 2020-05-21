/*
	算法思想：
		动态规划，第二次进行刷题
*/
 

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        //构建dp数组,dp数组表示s[i...j]是否为回文串
        boolean[][] dp = new boolean[len][len];

        //初始化dp数组
        for(int i=0;i<len;i++)
            dp[i][i] = true;

        //start记录最大子字符串的起始位置
        int start = 0;
        int maxLen = 1;
        for(int j = 1;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    //在判断两个位置的字符相等后，还不能进行状态转移，要继续进行判断
                    //对此时相等后，如果此时的双指针距离<3，则表示为回文串了，不需要进行状态转移
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        //状态转移
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = false;
                }

                //找到最大字符串，条件（dp[i][j]）为true,true表示s[i,j]为回文，此时就要进行长度的判断
                if(dp[i][j]){
                    int curLen = j-i+1;
                    if(curLen > maxLen){
                        maxLen = curLen;
                        start = i;
                    }
                }
            }
        }
        //用substring方法构建子串
        return s.substring(start,start+maxLen);
    }
}












