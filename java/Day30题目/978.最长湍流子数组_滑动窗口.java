/*
	算法思想：
		滑动窗口的思想，我考虑的是直接按照两种情况进行分开讨论，但是题解的思想更优化，通过考虑当前right-1的数进行判断！！！
		
题解：https://leetcode-cn.com/problems/longest-turbulent-subarray/solution/zui-chang-tuan-liu-zi-shu-zu-by-leetcode-t4d8/
*/


class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length;
        int res = 1;
        int left = 0,right = 0;

        while(right < n-1){
            if(left == right){
                //去重
                if(arr[left] == arr[left+1])
                    left++;
                right++;
            }else{
                if(arr[right-1] < arr[right] && arr[right] > arr[right+1])
                    right++;
                else if(arr[right-1] > arr[right] && arr[right] < arr[right+1])
                    right++;
                else{
                    
                    left = right;
                }
            }
            //在扩大窗口的时候进行数组长度的计算！
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}