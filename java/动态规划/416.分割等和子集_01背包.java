/*
	算法思想：
		0-1背包的变形！（labuladong）

*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num:nums)
            sum += num;
        //如果不能被2整除，则返回false
        if(sum % 2 != 0)
            return false;
        int n = nums.length;
        //dp数组表述nums.length个物品能否装满sum/2的背包
        boolean[][] dp = new boolean[n+1][sum/2+1];

        //base case
        //此时背包没有空间，相当于装满了
        for(int i=0;i<dp.length;i++)
            dp[i][0] = true;
        
        for(int j=1;j<dp[0].length;j++)
            dp[0][j] = false;

        //开始遍历
        //首先，由于 i 是从 1 开始的，而数组索引是从 0 开始的，所以第 i 个物品的重量应该是 nums[i-1]，这一点不要搞混。
        for(int i=1;i<=n;i++)
            for(int j=1;j<=sum/2;j++){
                //此时不能拿
                if(j - nums[i-1] < 0)
                    dp[i][j] = dp[i-1][j];
                else
                    //当前的背包是由前一个的两种状态转换过来的！
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                
            }

        return dp[n][sum/2];
    }
}