/*
	算法思想：
		怎么说呢，思想还是知道，但是，还是对于返回值的处理，出了点问题！！
		二刷还是没有通过！！！

*/

class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        Arrays.fill(memo,-1);
        return tryChange(coins,amount);
    }

    //由于是自顶向下，因此， 我们直接在amout上进行加减即可！！
   
    public int tryChange(int[] coins,int amount){
        if(0 == amount){
            return 0;
        }
         //注意，当某一个值无法满足硬币交换的条件，我们要返回-1
        if(0 > amount)
            return -1;

        if(memo[amount] != -1)
            return memo[amount];

        int res = (int)1e5;
        for(int i=0;i<coins.length;i++){
            int subproblem = tryChange(coins,amount-coins[i]);
            //如果subProblem为-1，说明，此时不能够进行硬币交换，需要进行下一次循环！
            if(subproblem == -1)
                continue;
            res = Math.min(subproblem+1,res);
        }
        memo[amount] = res;
        return memo[amount] == (int)1e5?-1:memo[amount];
    }
}