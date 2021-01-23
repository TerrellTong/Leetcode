/*
	算法思想：
		可以取无限次，按照套路，我们采用对可以是重复元素的数组，进行外层遍历，然后再进行内层遍历！！

*/

class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp数组表示amount 需要的硬币数
        //由于每个位置的硬币数量无限，因此不需要记录当前拿到了哪个位置pos
        int[] dp = new int[amount+1];

        //base case
        //让其余达不到的设为无穷大
        Arrays.fill(dp,amount+1);
        //dp[0]设置为0
        dp[0] = 0;
		
		//外层遍历重复元素
        for(int coin:coins){
        for(int i=1;i<=amount;i++){
            
                //此时不能兑换
                if(i-coin < 0)
                    continue;
                //此时能够兑换
                //但是我也可以选择不换或者换
                dp[i] = Math.min(dp[i],dp[i-coin]+1);
            }
        }
            

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}