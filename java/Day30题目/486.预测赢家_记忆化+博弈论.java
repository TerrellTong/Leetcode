/*
	算法思想：
		记忆化递归，博弈论
		

原理：https://leetcode-cn.com/problems/predict-the-winner/solution/ji-yi-hua-di-gui-dong-tai-gui-hua-java-by-liweiwei/
		
*/


class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
		//存取相对分数
        int[][] memo = new int[len][len];

        //用Integer.MIN_VALUE填充memo数组
        for(int i=0;i<len;i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }

        return dfs(nums,0,len-1,memo) >= 0;
    }

    //i表示数组的左端，j表示数组的右端
    public int dfs(int[] nums,int i,int j ,int[][] memo){
        if(i>j)
            return 0;
        if(memo[i][j] != Integer.MIN_VALUE)
            return memo[i][j];
        //选择左端
        int chooseLeft = nums[i] - dfs(nums,i+1,j,memo);
        //选择右端
        int chooseRight = nums[j] - dfs(nums,i,j-1,memo);
        memo[i][j] = Math.max(chooseLeft,chooseRight);
        return memo[i][j];
    }
}