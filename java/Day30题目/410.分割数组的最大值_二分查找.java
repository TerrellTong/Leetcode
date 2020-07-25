/*
	算法思想：
		二分查找！
「使……最大值尽可能小」是二分搜索题目常见的问法。
https://leetcode-cn.com/problems/split-array-largest-sum/solution/bai-hua-er-fen-cha-zhao-by-xiao-yan-gou/
https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-coder233-2/
*/

class Solution {
    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        //最大值的最小值的范围[max(nums),sum(nums)]]
        for(int num:nums){
            left = Math.max(left,num);
            right += num;
        }
        //开始进行二分查找
        while(left <= right){
            //由于最大值的最小值的范围已经确定了，我们采用二分查找
            int mid = (left+right) >>> 1;
            int temp = 0,count =1;
            for(int num:nums){
                temp += num;
                //判断前几个数组和是否大于mid，如果大于mid，则重新开始一个新数组(相当于又划分了一次)
                if(temp > mid){
                    temp = num;
                    count++;
                }
            }
            //如果count大于给定的m次数，那么说明mid确定小了，准确的范围在右区间
            if(count > m)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
}