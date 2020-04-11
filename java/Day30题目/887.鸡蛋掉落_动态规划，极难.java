/*
	算法思想：
	动态规划
		定义dp状态
		假设dp[k][j] = N 代表有k个鸡蛋，操作次数为j时，包含F楼层的最大层数为N。
		按照层数j = 1,2,3,4不断的迭代，第一个 >= N的dp[k][j]的j就时所求的最小移动次数。
		状态转移方程：
		j和j-1有什么关系。

		设 dp[k][j] = NN， dp[k][j] 可以由两个状态转换过来
		在[1,NN]中随便选1层 X 扔鸡蛋，有两种情况，扔下去碎了，那么F一定在 [0,X-1]中，这是dp[k][j]的状态就退化成了
		dp[k-1][j-1] , 即k-1个鸡蛋，操作数为j-1, 即 dp[k-1][j-1] 代表 [0,X-1]
		如果没碎，F一定在[X,NN]中,这时dp[k][j]的状态就退化成dp[k][j-1]

		在回顾一下dp[k][j]的含义， dp[k][j] 代表了 [0,N]这样一个区间
		dp[k][j-1]代表[X,NN] - > [0,NN-X] -> dp[k][j-1] = NN - X
		dp[k-1][j-1] 代表[0,X-1] -> dp[k-1][j-1] = X - 1
		但是dp[k][j] = NN = (X - 1) + (NN - X) + 1 = dp[k][j-1] + dp[k-1][j-1] + 1

		这就是为啥有这个1。

作者：blade-4
链接：https://leetcode-cn.com/problems/super-egg-drop/solution/ken-ding-rang-ni-li-jie-de-si-lu-by-blade-4/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
				
*/

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];
        for (int m = 1; m <= N; m++) {
            dp[0][m] = 0; // zero egg
            for (int k = 1; k <= K; k++) {
                dp[k][m] = dp[k][m - 1] + dp[k - 1][m - 1] + 1;
                if (dp[k][m] >= N) {
                    return m;
                }
            }
        }
        return N;
    }
}











