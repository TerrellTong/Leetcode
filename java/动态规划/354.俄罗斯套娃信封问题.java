/*
	算法思想：
		左边升序，相等的值，右边降序，相当于是找最长上升子序列
		我想到了排序，没想到右边要降序！！
		
		排序 + 最长递增子序列
	
题解：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/e-luo-si-tao-wa-xin-feng-wen-ti-by-leetcode/
	
*/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        //左边升序，相等的值，右边降序
        Arrays.sort(envelopes,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]==b[0] ? b[1]-a[1] : a[0]-b[0];
            }
        });

        int[] height = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++)
            height[i] = envelopes[i][1];

        //找右边的最长升序序列
        int res = 0;
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        for(int i=0;i<height.length;i++)
            for(int j=0;j<i;j++){
                if(height[i] > height[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }

        for(int d:dp)
            res = Math.max(d,res);
        return res;
    }
}