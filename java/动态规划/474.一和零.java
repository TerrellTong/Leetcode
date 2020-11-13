/*
	算法思想：
		看不懂！！！
		
题解：https://leetcode-cn.com/problems/ones-and-zeroes/solution/zi-ding-xiang-xia-ji-yi-sou-suo-zi-di-xiang-shang-/
*/

class Solution {
    int[][][] memo;
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0 || (m == 0 && n == 0))
            return 0;
        //memo初始化
        memo = new int[strs.length][m+1][n+1];
        for(int i=0;i<memo.length;i++)
            for(int j=0;j<memo[i].length;j++)
                Arrays.fill(memo[i][j],-1);

        return tryFindMaxForm(strs,strs.length-1,m,n);
    }

    //用m,n拼出strs[0,i]的最大个数
    public int tryFindMaxForm(String[] strs,int i,int m,int n){
        if(i < 0)
            return 0;
        
        if(memo[i][m][n] != -1)
            return memo[i][m][n];

        //计算第i个字符串中，0,1个数
        int num_0 = 0;
        int num_1 = 0;
        String str = strs[i];
        for(int j=0; j< str.length();j++){
            if(str.charAt(j) == '0')
                num_0++;
            else
                num_1++;
        }
        //m和n的个数都是大于等于当前字符串的个数，则可以进行0-1背包的状态转移
        //1+xx  是选择当前数字
        if(m >= num_0 && n >= num_1){
            memo[i][m][n] = Math.max(tryFindMaxForm(strs,i-1,m,n) , 1+tryFindMaxForm(strs,i-1,m-num_0,n-num_1));
        }else{
            memo[i][m][n] = tryFindMaxForm(strs,i-1,m,n);
        }
        return memo[i][m][n];
    }
}