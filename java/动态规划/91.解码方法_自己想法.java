/*
	算法思想：
		我们要以i和i-1进行讨论！！ 不能再是i,i+1的思想了！！
		dp，转移方程想错了！，边界没处理，通过了大部分！
		
		dp数组含义找到了
		状态转移的含义：如果当前不是10~26，则dp[i] = dp[i-1] 表示当前只能分开译码
		如果是10~26，则dp[i] = dp[i-1]+dp[i-2] 表示可以分开译码和合并译码（dp[i-2]）  我自己写的合并译码是dp[i] = dp[i-1]+1!!!错误！
		
		
		对于0的特殊处理！！
		
		dp[i-1]：,dp[i-2]
		

*/

class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (s.charAt(0) == '0' || len == 0) return 0;
        //表示以len结尾的编码总数
        int[] dp = new int [len+1];
        dp[0] = 1;

        //对于dp[1]的讨论
        if(len > 1){
            char c = s.charAt(0);
            if( c == '1' && s.charAt(1) != '0'){
                dp[1] = 2;
            }else if (c == '2' && s.charAt(1) != '0' && s.charAt(1) <= '6')
                dp[1] = 2;
            else 
                dp[1] = 1;
        }else
            //字符串的长度小于1，则返回1 
            return 1;

        //i表示移动到的末尾位置
        for(int i=2;i<len;i++){
            char c = s.charAt(i); 
            char pre = s.charAt(i-1);

            if(c == '0'){
                if(pre == '1' || pre == '2')
                    dp[i] = dp[i-2];
                else
                    dp[i] = 0;
            }
            //如果前一个是1，则一定会出现两种情况
            else if(pre == '1')
                dp[i] = dp[i-1]+dp[i-2];
            else if(pre == '2' && c <= '6')
                dp[i] = dp[i-1]+dp[i-2];
            else
                dp[i] = dp[i-1];
        }

        return dp[len-1];
    }
}