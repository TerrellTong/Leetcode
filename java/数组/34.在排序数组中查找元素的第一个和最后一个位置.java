/*
	算法思想：
		二分查找
*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1,-1};
        int left = 0;
        int right = nums.length-1;
        //由于添加了<= ，因此此时如果存在target，此时的left为目标节点的位置，
        //如果不存在target，那么此时left指向的就是比target大的最小值，例如1,3,8 我们找7，那么left返回的是2，如果是9，返回的是3
        while(left <= right){
            //找到中点
            int mid = (left + right) >>> 1;
            if(nums[mid] < target)
                left = mid+1;
            else 
                right = mid-1;
        }

        if(left == nums.length)
            return new int[]{-1,-1};

        //找到最后的位置
        if(nums[left] == target){
            int end = left+1;
            while(end < nums.length){
                if(nums[end] != target)
                    break;
                end++;
            }
            return new int[]{left,end-1};
        }else   
            return new int[]{-1,-1};
    }
}