/*
	算法思想：
		动态规划，
		如果要判断i,...j是回文串，那么我们需要s 的第 i 和 j 个字母相同，这样我们可以进行状态转化，dp[i][j] = dp[i+1][j-1]
		我们需要两个指针，构成一个小的区间，因此，j=1,i=0这样就满足了条件
		
题解思路：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/

*/

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        //字符串的长度小于2，默认为回文字符串
        if(len < 2)
            return s;
        //构建dp数组，dp[i][j]表示从i...j是否为回文串
        boolean[][] dp = new boolean[len][len];

        //start记录最大子字符串你的起始位置
        int start = 0;
        int maxLen = 1;
        //我需要构造出一个区间
        for(int j=1;j<len;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    //只有当两者相等的时候，才会出现状态转移
                    //只有 s[i+1:j-1] 是回文串，并且 s 的第 i 和 j 个字母相同时，s[i:j] 才会是回文串。
                    //例如 ababa,i指向第一个a,j指向最后一个a
                    //如果j-i<3，说明已经为回文串了，不需要状态转移
                    if(j-i < 3)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }else
                    dp[i][j] = false;

                //如果出现回文串，则进行长度的判断
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