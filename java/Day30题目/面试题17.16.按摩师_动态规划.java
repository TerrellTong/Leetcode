/*
	算法思想：
		动态规划
	第 2 步：状态转移方程（根据状态的选择进行比较，取最优）
	这个时候因为不限定下标为 i 这一天是否接受预约，因此需要分类讨论：

	接受预约，那么昨天就一定休息，由于状态 dp[i - 1] 的定义涵盖了下标为 i - 1 这一天接收预约的情况，状态只能从下标为 i - 2 的状态转移而来：dp[i - 2] + nums[i]；
	不接受预约，那么昨天可以休息，也可以不休息，状态从下标为 i - 1 的状态转移而来：dp[i - 1]；
	二者取最大值，因此状态转移方程为 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])。

*/

class Solution {
    public int massage(int[] nums) {
         int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int [nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            //状态转移方程中代表的是当前天数接收预约和不接受预约的情况
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}

作者：liweiwei1419
链接：https://leetcode-cn.com/problems/the-masseuse-lcci/solution/dong-tai-gui-hua-by-liweiwei1419-8/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。



dfs超时
class Solution {
   public int massage(int[] nums) {
    dfs(nums,0,0);
    return max;
    }


    int max=0;
    void dfs(int[]nums,int index,int sum){
        if(index>=nums.length) {
            max=Math.max(sum,max);
        }
        
        //从第i个开始继续往下找
        for(int i=index;i<nums.length;i++){
            dfs(nums,i+2,sum+nums[i]);
        }

    }
}
