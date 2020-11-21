/*
	算法思想：
		LIS问题！
		本题中，状态转移方程可以考虑为dp[n]表示数组中到第n个数字的最长摆动序列长度，那么这个序列最后一个差值就可能是负数或者正数两种情况，
		所以一维的状态转移方程不能清楚的表示子问题的状态，需要再加一个维度，dp[n][m]，m表示最后一个差值的状态，0表示为负数，1表示为正数，那么状态转移方程就出来了
		
		正负两种情况，我们要分开讨论，不能一起讨论！！！
		
		
题解：https://leetcode-cn.com/problems/wiggle-subsequence/solution/javashi-xian-chao-guo-100-by-meitianxiaoyixiao/（看第一条评论）
		
*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2)
            return nums.length;
        
        //0表示差值为负数，1表示差值为正数
        int[][] dp = new int[nums.length+1][2];
        //初始化
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[0].length;j++)
                dp[i][j] = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] > nums[i-1]){
                //此时上升的可以从之前的下降序列转移过来 或者 直接从上一个的上升序列转移过来
                dp[i][1] = Math.max(dp[i-1][0]+1,dp[i-1][1]);
            }else if(nums[i] < nums[i-1])
                dp[i][0] = Math.max(dp[i-1][1]+1,dp[i-1][0]);
            else{
                dp[i][1] = dp[i-1][1];
                dp[i][0] = dp[i-1][0];
            }
        }

        return Math.max(dp[nums.length-1][1],dp[nums.length-1][0]);
    }
}