 /*
	算法思想：
	动态规划（穷举），套路1）找到状态2）找到db数组的含义3）明确选择4）明确baseline

 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0)
            return -1;
        //m数组存储所需硬币的个数
        int memo[] = new int[amount+1];
        memo[0] = 0;
        //从金币1开始向上找
        for(int i=1;i<=amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++){
                if(i-coins[j]>=0&&memo[i-coins[j]]<min){
                    min =  memo[i-coins[j]]+1;
                }
            }
            memo[i] = min;
        }
         return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}
