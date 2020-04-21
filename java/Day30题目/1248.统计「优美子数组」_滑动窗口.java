/*
	算法思想：
		滑动窗口
*/


class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // 滑窗
        int res=0,count=0;
        int left=0,right=0;
        int tmp=0;
        while (right<nums.length){
            //如果当前奇数的个数小于k,则滑动窗口右移
            if (count<k){
                count+=nums[right]&1;
                right++;
            }
            if (count==k){
                tmp=0;
                while (count==k){
                    ++res;++tmp;
                    //进行取余操作,然后再用count对其进行相减，然后滑动窗口左移
                    count-=nums[left]&1;
                    ++left;
                }
            }
            else 
                res+=tmp;
        }
        return res;
    }
}












