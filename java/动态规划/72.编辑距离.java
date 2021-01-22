/*
	算法思想：
		如果两个字符串的长度是n1,n2，那么其相乘的结果最大长度不会超过n1+n2！
		我们直接将结果放入数组即可
		其第一位（进位）位于 res[i+j]，第二位（应在的位置）位于 res[i+j+1]。
		
		之前的每日一题，还是不会！！
	
题解：https://leetcode-cn.com/problems/edit-distance/solution/zi-di-xiang-shang-he-zi-ding-xiang-xia-by-powcai-3/

对于编辑距离的转移含义，可以看看上面的评论区1
	
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        //dp数组的含义：以i位置为终止与以j位置为终止的最小编辑距离
        int[][] dp = new int [len1+1][len2+1];
        //base case
        for(int i=0;i<=len1;i++)
            dp[i][0] = i;
        for(int j=0;j<=len2;j++)
            dp[0][j] = j;

        //遍历
		//只能从1开始，因为有i-1
        for(int i=1;i<=len1;i++)
            for(int j=1;j<=len2;j++){
                //如果此时word1上的字符与word2上的字符相等，则说明dp[i][j]的编辑距离为dp[i-1][j-1]
				//由于i=1,j=1,此时通过i-1,j-1来模拟第i个字符的值！
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    //此时i上的字符与j上的字符不相等，需要进行操作
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1//i被删除
                                        ,dp[i-1][j-1]+1) //i被替换，此时i,j的位置是相等的，与上面的转换类似
                                        ,dp[i][j-1]+1);//在i上插入，插入操作的含义：把前i个字符替换成j-1，然后再+1
                }
            }
        
        return dp[len1][len2];
    }
}