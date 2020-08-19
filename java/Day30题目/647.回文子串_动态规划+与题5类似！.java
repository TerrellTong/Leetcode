/*
	算法思想：
		回文串的思想，动态规划，可以结合T5的思想！！
		忘了具体咋做了！！
	
*/


class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.equals(""))
            return 0;
        int n = s.length();
        //表示从i到j是否是回文串
        boolean[][] dp = new boolean[n][n];
        //由于每单个字符使一个结果，因此，我们直接将s.length()赋给result
        int result = s.length();
        for(int i=0;i<n;i++)
            dp[i][i] = true;
        //判断两个字符以上的回文字符有多少！
        for(int j=1;j<n;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    //i和j相邻的时候

                    if(j-i == 1)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                }else
                    dp[i][j] = false;
                if(dp[i][j])
                    result++;
            }
        }
        return result;
    }
}