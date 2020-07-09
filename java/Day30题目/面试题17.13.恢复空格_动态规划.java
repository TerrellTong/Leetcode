/*
	算法思想：
		动态规划！
		怎么思考一个题目可不可以用 dp 来解决，先假设 dp 表达含义，再想转移方程，很多时候自然而然就出来了
		dp[i] 含义，即为题目的要求含义
		状态转移方程
			假设当前我们已经考虑完了前 i 个字符了，对于前 i + 1 个字符对应的最少未匹配数：

		1）第 i + 1 个字符未匹配，则 dp[i + 1] = dp[i] + 1，即不匹配数加 1;
		2）遍历前 i 个字符，若以其中某一个下标 idx 为开头、以第 i + 1 个字符为结尾的字符串正好在词典里，
		则 dp[i] = min(dp[i], dp[idx]) 更新 dp[i]。

https://leetcode-cn.com/problems/re-space-lcci/solution/jian-dan-dp-trieshu-bi-xu-miao-dong-by-sweetiee/

		
*/
class Solution {
    public int respace(String[] dictionary, String sentence) {
        //将String[]数组转成List后，然后转成Set
        Set<String> dict = new HashSet(Arrays.asList(dictionary));
        int n = sentence.length();
        //dp数组表示前i个字符的最少未匹配数
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            //如果前i-1个字符未匹配，则不匹配数+1
            dp[i] = dp[i-1]+1;
            for(int idx = 0;idx<=i;idx++){
                if(dict.contains(sentence.substring(idx,i)))
                    dp[i] = Math.min(dp[i],dp[idx]);
            }
        }
        return dp[n];
    }
}





