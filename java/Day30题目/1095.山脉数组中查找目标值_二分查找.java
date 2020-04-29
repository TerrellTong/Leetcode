/*
	算法思想：
		二分查找
*/


/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int end = mountainArr.length()-1;
        int start = 0;
        int mid = 0;
        //二分查找，找山顶
        while(start <= end){
            //mid更新
            mid = start+(end - start)/2;
            if(mid == 0)
                mid++;   //防止溢出
            if(mid == mountainArr.length()-1) mid--;
            int midNum = mountainArr.get(mid);
            int rightNum = mountainArr.get(mid+1);
            int leftNum = mountainArr.get(mid-1);
            //找山顶
            if(midNum > leftNum && midNum > rightNum )
                break;
            //说明山顶在mid左边,此时在右山坡
            if(leftNum > midNum && midNum > rightNum){
                end = mid - 1;
            }else if(leftNum < midNum && midNum < rightNum)
                start = mid + 1;
        }

        //找到山顶后，再次二分查找，找山腰两边的数
        int left = asc_binarySearch(0,mid,target,mountainArr);
        int right = des_binarySearch(mid+1,mountainArr.length()-1,target,mountainArr);
        if(left == -1)
            return right;
        return left;
    }

    public int asc_binarySearch(int start,int end,int target,MountainArray mountainArr){
        while(start <= end){
            int mid = start+(end - start)/2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(mountainArr.get(mid) < target)
                start = mid +1;
            else  
                end = mid-1;
        }
        return -1;
    }

        public int des_binarySearch(int start,int end,int target,MountainArray mountainArr){
        while(start <= end){
            int mid = start+(end - start)/2;
            if(mountainArr.get(mid) == target)
                return mid;
            if(mountainArr.get(mid) < target)
                end = mid-1;
            else  
                start = mid +1;
        }
        return -1;
    }

}












