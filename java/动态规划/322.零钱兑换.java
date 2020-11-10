/*
	算法思想：
		记忆化搜索，大致思路写了出来，但是还有一点问题，我是不管能不能换零钱，我都使结果+1了！
		
题解：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-leetcode-solution/

*/

class Solution {
    //存储第i个元素，所需要的硬币数
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-1);

        return tryChange(coins,amount);
    }

    public int tryChange(int[] coins,int amount){
        if(amount == 0)
            return 0;
        if(amount < 0)
            return -1;
        
        if(memo[amount] != -1)
            return memo[amount];

        int res = (int)1e5;
        //进行拆分
        for(int i=0;i<coins.length;i++){
            int subproblem = tryChange(coins,amount-coins[i]);
            //此时需要判断子问题的答案是否为-1，如果为-1，则说明不能换零钱！直接退出
            //我是不管能不能换零钱，我都+1了！！
            if(subproblem == -1)
                continue;
            res = Math.min(res,subproblem+1);
        }

        memo[amount] = res;
        return memo[amount] == (int)1e5 ? -1 : memo[amount];
    }
}