/*
	算法思想：
		前缀和
*/
 
class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        //记录前缀和，为了后面的判断方便，声明preSum[i+1]代表前i个连续字符之和
        for(int i=0;i<len;i++){
            preSum[i+1] = preSum[i]+nums[i];
        }
        //从左开始遍历
        for(int left = 0;left<len ;left++)
            for(int right = left;right<len;right++){
                //preSum[right+1]表示当前位置的前right之和
                //preSum[left]表示当前位置的left-1的前left之和
                //两者之差即为[left,right]的连续子数组和
                if(preSum[right+1] - preSum[left] == k)
                    res++;
            }
        return res;
    }
}











