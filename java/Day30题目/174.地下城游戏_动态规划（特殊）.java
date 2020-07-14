/*
	算法思想：
		动态规划，特殊的，由于要确保起始的最低体力值，因此要从右下往左上遍历
		遍历顺序：1）题目要求的位置是哪，就从它的对角处开始遍历
		
*/
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        //声明dp数组
        int[][] dp = new int [m+1][n+1];
        //给二维数组都赋值为MAX_VALUE
        //只能用Arrays.fill，不然的话会报错
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        //初始化,由于从dp[m-1][n-1]开始遍历的时候，此时的dp数组转换的值是无意义的
        dp[m][n-1] = dp[m-1][n] = 1;
        //由于要确保起始的最低体力值，因此要从右下往左上遍历
        for(int i=m-1;i>=0 ;i--){
            for(int j=n-1;j>=0;j--){
                //为什么要和1比较，因为，如果-dungeon[i][j]后的结果为负值，说明此时的dungeon[i][j]，为正数，说明此时只需要健康点数为1即可满足要求
                //例如 题目的10 30 -5 （最后一行）往里面套即可
                dp[i][j] = Math.max(Math.min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1);
            }
        }
        return dp[0][0];
    }
}





