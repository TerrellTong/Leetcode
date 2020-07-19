/*
	算法思想：
		动态规划，从下往上从左往右进行遍历！！特殊！
		
https://leetcode-cn.com/problems/burst-balloons/solution/dong-tai-gui-hua-tao-lu-jie-jue-chuo-qi-qiu-wen-ti/
*/
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n+2];
        points[0] = 1;
        points[n+1] = 1;
        //将nums数组转换成new_nums,相当于进行了错位
        //添加两个虚拟的气球
        for(int i=1;i<=n;i++){
            points[i] = nums[i-1];
        }
        //问题转换:在一排气球points中，请戳破气球0和气球n+1之间的所有气球(不包括0和n+1),使得最终只剩下气球0和n+1两个气球，最多能得到多少分
        //dp数组含义:dp[i][j] = x表示:戳破气球i和气球j之间(开区间,不包括i和j)的所有气球，能得到的最高分数为x
        //base case已经被初始化为0
        int[][] dp = new int[n+2][n+2];
        //开始状态转移
        //i从下往上
        for(int i=n;i>=0;i--){
            //j应该从左往右
            for(int j=i+1;j< n+2;j++){
                //最后戳破的气球是哪个？
                for(int k=i+1;k<j;k++){
                    //择优做选择
                    dp[i][j] = Math.max(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + points[i]*points[k]*points[j]
                    );
                }
            }
        }
        return dp[0][n+1];
    }
}





