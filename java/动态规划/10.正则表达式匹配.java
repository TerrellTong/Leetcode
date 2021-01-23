/*
	算法思想：
		其余的想了出来，*没有考虑完全！
		*的三种情况：//去掉 b* ,例如 qqb,qqbb*与下面的类似，dp[i][j] = dp[i][j-2]
                     //去掉*，例如qqb,qqb*，dp[i][j] = dp[i][j-1]
                     //留这个*，例如aaaa,a*，我们,dp[i][j] = dp[i-1][j]
			
题解	https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-zen-yao-cong-0kai-shi-si-kao-da-b/ （状态转移看这个）
	https://leetcode-cn.com/problems/regular-expression-matching/solution/dong-tai-gui-hua-di-gui-xiang-jie-by-tin-oycu/  （完整代码看这个）
*/


class Solution {
    public boolean isMatch(String s, String p) {
        //s长度为i,p的长度j，他们能否匹配
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        
        //base case
        //两者长度都为0，则是false
        dp[0][0] = true;
        //s为空串，p不为空串
        //如果为*，则可以消除前一个字符，即根据之前的+删除*，因此就是dp[0][i] == dp[0][i-2]
        for (int i = 2; i <= p.length(); i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }

        for(int i=1;i<=s.length();i++)
            for(int j=1;j<=p.length();j++){
                //如果当前位置的字符相等，则说明当前状态是由前一个状态转移的
                if(s.charAt(i-1) == p.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    //此时i,j上的元素不等
                    //如果是. 说明也是相等的
                    if(p.charAt(j-1) == '.')
                        dp[i][j] = dp[i-1][j-1];
                    else if(p.charAt(j-1) == '*'){
                        //当前是*，我们需要判断*的前一个位置是否与当前相等
                        if(p.charAt(j-2) == s.charAt(i-1) || p.charAt(j-2) == '.'){
                            //去掉 b* ,例如 qqb,qqbb*与下面的类似，dp[i][j] = dp[i][j-2]
                            //去掉*，例如qqb,qqb*，dp[i][j] = dp[i][j-1]
                            //留这个*，例如aaaa,a*，我们,dp[i][j] = dp[i-1][j]
                            dp[i][j] = dp[i][j-2] || dp[i][j-1] || dp[i-1][j];
                            
                        }
                        else
                            //此时* +前面的值，不能正确的匹配，前面的字符
                            //相当于直接删除* 前面的值！ 例如 ab 和 abc* 可以匹配，*可以看成是匹配0个,因此直接从j-2开始
                            dp[i][j] = dp[i][j-2];

                    }
                    else
                        //此时就是不相等
                        dp[i][j] = false;
                }
            }


        return dp[s.length()][p.length()];
    }
}