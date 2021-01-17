/*
	算法思想：
		前缀和问题，用滑动窗口好像做不出来！！！尝试过滑动窗口了！
		8个月前做过，还是不会！！！
		
	题解：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/  思路3
	
*/


class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        //存储前缀和数组
        int[] presum = new int[nums.length+1];
        presum[0] = 0;

        //计算前缀和
        for(int i=0;i<len;i++){
            presum[i+1] = presum[i]+nums[i];
        }
        int count = 0;
        //从left开始，计算right和left之间的前缀和
        for(int left=0;left<len;left++){
            for(int right = left;right<len;right++){
                if(presum[right+1] - presum[left] == k)
                    count++;
            }
        }
        return count;
    }
}