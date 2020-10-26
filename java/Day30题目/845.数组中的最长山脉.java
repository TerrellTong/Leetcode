/*
	算法思想：
		双指针，上坡++，下坡++，如果上坡为0，说明要前移动！！
		
题解：https://leetcode-cn.com/problems/longest-mountain-in-array/solution/
*/

class Solution {
    public int longestMountain(int[] A) {
        int ans = 0,n = A.length;

        int i = 0;
        while(i < n){
            int up = 0,down = 0;
            while(i < n-1 && A[i] < A[i+1]){
                i++;
                up++;
            }
            if(up > 0){
                while(i < n-1 && A[i] > A[i+1]){
                    i++;
                    down++;
                }
            }
            //同时完成了，上坡和下坡，说明找到了山脉，更新答案
            if(up > 0 && down > 0){
                ans = Math.max(ans,up+down+1);
            }
            //爬坡失败
            if(up == 0)
                i++;
        }
        return ans;
    }
}
