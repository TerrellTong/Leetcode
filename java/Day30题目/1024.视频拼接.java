/*
	算法思想：
		动态规划
		把dp数组想成了二维，dp数组是二维数组！！
	

图解：https://leetcode-cn.com/problems/video-stitching/solution/shou-hua-tu-jie-dong-tai-gui-hua-si-lu-pou-xi-xian/
题解：https://leetcode-cn.com/problems/video-stitching/solution/shi-pin-pin-jie-by-leetcode-solution/

*/

class Solution {
    public int videoStitching(int[][] clips, int T) {
        //dp[i] 表示将区间 [0,i)[0,i) 覆盖所需的最少子区间的数量
        int[] dp = new int[T + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
        //求dp[j]，通过dp[1]开始转移到dp[j]
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                //如果i是在clip[0]和clip[1]之间，则进行dp转移方程
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[T] == Integer.MAX_VALUE - 1 ? -1 : dp[T];
    }
}
