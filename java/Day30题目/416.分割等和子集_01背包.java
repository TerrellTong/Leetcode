/*
	算法思想：
		0-1背包
		
思路：https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
*/

class Solution {
    //等价于能否从输入数组中挑选出一些正整数，使得这些正整数的和为整个数组元素和一半
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return false;
        }
        int sum = 0;
        for(int num:nums){
            sum += num;
        }

        //如果和不为偶数，说明找不到
        if((sum % 2 != 0)){
            return false;
        }

        int target = sum/2;
        //创建二维状态数组，行：物品索引，列：容量（包括0）
        //dp[i][j] 表明前i个物品，总数和等于j, 是否满足，满足为true,不满足为false
        boolean[][] dp = new boolean[len][target+1];

        //此时没有拿到物品，而且总和数为0
        dp[0][0] = true;
        
        //特殊状态，当第一个数刚好为target
        if(nums[0] == target)
            dp[0][nums[0]] = true;

        //状态转移
        for(int i=1;i<len;i++){
            for(int j=0;j<=target;j++){
                //此位置的含义不知道？？
                dp[i][j] = dp[i-1][j];
                if(nums[i] <= j)
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
            }

            if(dp[i][target])
                return true;
        }
        return dp[len-1][target];

    }
}
