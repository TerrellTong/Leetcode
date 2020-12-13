/*
	题目描述：
		鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
	
	算法思想：
		属于区间记忆化搜索的一部分
		之前用的贪心（不对），我知道要用dp，但是不知道dp怎么定义
		这里是用memo代替dp，大致含义类似，判断当前区间，所选的值
		
		
		数组记录的为当前先手时能拿到的相对最大值。
		由题意可知其实Alice和Bob都想尽可能使得最后的结果最大，这样才能满足最大（最小）分差的要求
		
题解：https://leetcode-cn.com/problems/stone-game-vii/solution/java-ji-yi-hua-di-gui-by-ppppjqute-r9u1/

*/

class Solution {
    //二维数组，代表是当前选择左/右时，所取的最大值
    int[][] memo;
    public int stoneGameVII(int[] stones) {
        this.memo = new int[stones.length+1][stones.length+1];
        for(int i=0;i<=stones.length;i++){
            Arrays.fill(memo[i],Integer.MIN_VALUE);
        }
        int sum = Arrays.stream(stones).sum();
        return dfs(stones,0,stones.length-1,sum);
    }

    public int dfs(int[] stones,int left,int right,int sum){
        if(left == right)
            return 0;
        if(memo[left][right] != Integer.MIN_VALUE)
            return memo[left][right];

        int chooseLeft = sum - stones[left] - dfs(stones,left+1,right,sum-stones[left]);
        int chooseRight = sum - stones[right] - dfs(stones,left,right-1,sum-stones[right]);
        int res = Math.max(chooseLeft,chooseRight);
        memo[left][right] = res;
        return res;
    }
}
