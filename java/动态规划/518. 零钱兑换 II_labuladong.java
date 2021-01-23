/*
	算法思想：
		可以取无限次，按照套路，我们采用对可以是重复元素的数组，进行外层遍历，然后再进行内层遍历！！

*/

class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        //base case
        dp[0] = 1;
		//外层遍历重复元素
        for(int coin:coins){
        for(int i=1;i<=amount;i++){
                if(i-coin < 0)
                    continue;
                //当前dp为可以有dp[i-coin]拿，也可以有dp[i]拿去
				//因此dp[i]为两者相加！！！
                dp[i] = dp[i-coin]+dp[i];
            }
        }

        return dp[amount];
    }
}