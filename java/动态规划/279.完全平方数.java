/*
	算法思想：
		dp,与整数拆分的思路类似，i~n/2可以无限用！放到外层循环
		自己做了出来
*/


class Solution {
    public int numSquares(int n) {
        if(n <= 3) 
            return n;


        int[] dp = new int[n+1];
        //base case 
        Arrays.fill(dp,Integer.MAX_VALUE-10000);
        for(int i=1;i*i <= n;i++)
            dp[i*i] = 1;
        dp[2] = 2;
        dp[3] = 3;


        //拆分
        for(int i =1;i<n/2;i++){
            for(int j=5;j<=n;j++){
                //不能拆分
                if(j - i*i < 0){
                    continue;
                }else
                    dp[j] = Math.min(dp[j],dp[j-i*i]+1);
            }
        }

        return dp[n];
    }
}