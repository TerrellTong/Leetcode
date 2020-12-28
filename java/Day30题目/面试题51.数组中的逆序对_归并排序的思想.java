/*
	算法思想：
		归并排序，按照归并排序的模板写的
		
题解：https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/java-gui-bing-fa-by-1yx/  评论区
*/


class Solution {
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        return merger(nums,0,nums.length-1,tmp);
    }

    public int merger(int[] nums,int low,int high,int[] tmp){
        if(low < high){
            int mid = (low + high) >>> 1;
            int left = merger(nums,low,mid,tmp);
            int right = merger(nums,mid+1,high,tmp);
            
            int cross = mersort(nums,low,mid,high,tmp);
            return left+cross+right;
        }
        return 0;
    }

    public int mersort(int[] nums,int low,int mid,int high,int[] tmp){
        int index = 0;
        int i = low;
        int j = mid+1;
        int count = 0;
        while(i <= mid && j<=high){
            //一定要取等于，不然的话，当出现重复元素，还会重复计算
            if(nums[i] <= nums[j]){
                
                tmp[index++] = nums[i++];
            }else{
                //出现逆序对
                count += mid+1 - i;
                tmp[index++] = nums[j++];
            }
        }

        while(i<=mid){
            tmp[index++] = nums[i++];
        }
        while(j <= high){
            tmp[index++] = nums[j++];

        }
        for(int t=0;t<index;t++)
            nums[low+t] = tmp[t];
        return count;
    }
}













