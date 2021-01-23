/*
	算法思想：
		可以取无限次，按照套路，我们采用对可以是重复元素的数组，进行外层遍历，然后再进行内层遍历！！

*/

class Solution {
    public int integerBreak(int n) {
        if(n == 2)
            return 1;
        if( n == 3)
            return 2;
        int[] dp = new int[n+1];
        //base case,不能按照dp[1]=0,如果这样的话，再次进行拆分会出现问题  例如3 = 2+1，dp[1]*2，如果取0,则取值为0，不满足题意！！
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
		//外层遍历，是可以取的重复元素
        for(int i=0;i<=n;i++){
			//内层遍历，是我们想要的值！
            for(int j=3;j<=n;j++){
                if(j - i < 0)
                    continue;
                dp[j] = Math.max(dp[j],dp[j-i]*i);
            }
        }
        return dp[n];
    }
}