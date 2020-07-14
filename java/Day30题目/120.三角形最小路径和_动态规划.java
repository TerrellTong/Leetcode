/*
	算法思想：
		动态规划，通式的状态转移方程写对了一半，但是还是漏掉了
		特殊情况未考虑！！
	
https://leetcode-cn.com/problems/triangle/solution/san-jiao-xing-zui-xiao-lu-jing-he-by-leetcode-solu/
		
*/
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        //注意第i行有i+ 1个元素，它们对应的j的范围为[0,i].当j= 0或j= i时，上述状态转移方程中有一些项是没有意义的
        //例如当j=0时，f[i- 1][j- 1] 没有意义,因此两种特殊情况的状态转移方程要单独书写
        for(int i=1;i<n;i++){
            f[i][0] = f[i-1][0] + triangle.get(i).get(0);
            for(int j = 1;j<i;j++)
                f[i][j] = Math.min(f[i-1][j-1],f[i-1][j]) + triangle.get(i).get(j);
            f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
        }
        //从最后一行中进行遍历
        int minTotal = f[n-1][0];
        for(int i=1;i<n;i++)
            minTotal = Math.min(minTotal,f[n-1][i]);
        return minTotal;
    }
}





