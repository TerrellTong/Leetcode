/*
	算法思想：
		之前做过，相当于二刷，成功！！
		定义两个状态，分别表示从负到正。从正到负
		当是递增的时候，我们的dp[i][0] 可以从上一个状态的dp[i-1][1]+1（从减到增） 或者是上一个数字的0状态转移过来
*/

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 0)
            return 0;
        //两个状态，0表示从负到正，1表示从正到负
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for(int i=1;i<nums.length;i++){
            //当前状态为0，即表示是从负到正
            if(nums[i] - nums[i-1] > 0){
                dp[i][0] = Math.max(dp[i-1][1]+1,dp[i-1][0]);
                dp[i][1] = dp[i-1][1];
            }
            else if(nums[i] == nums[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
            }
            else{
                dp[i][0] =  dp[i-1][0];
                dp[i][1] =  Math.max(dp[i-1][0]+1,dp[i-1][1]);
            }
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
