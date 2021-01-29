/*
	算法思想：
		简单的前缀和
*/


class Solution {
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];

        //计算左边前缀和,不包括当前索引的值
        for(int i=1;i<nums.length;i++){
            leftSum[i] = leftSum[i-1]+nums[i-1];
        }
        //计算右边前缀和，不包括当前索引的值
        for(int i=nums.length-2;i>=0;i--){
            rightSum[i] = rightSum[i+1]+nums[i+1];
        }

        //找中心索引
        int res = -1;
        for(int i=0;i<nums.length;i++){
            if(leftSum[i] == rightSum[i]){
                res = i;
                break;
            }
        }

        return res;
    }
}