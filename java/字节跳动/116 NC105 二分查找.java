/*
	算法思想：
		二分，主要是题目说的有点问题，当为>=时，我们需要进一步的进行判断，如果mid之前的数还是>=，则可以让right进行移动，否则直接返回
		特判：如果mid==0,则说明之后的元素都比v大，我们直接返回mid+1即可！！！
		
题解：https://www.nowcoder.com/questionTerminal/7bc4a1c7c371425d9faa9d1b511fe193   牛客430087014
*/



public class Solution {
    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int left = 0;
        int right = a.length-1;
        int res = 0;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(a[mid] >= v){
                //如果数组的第一个元素就大于v,则直接加1返回
                if(mid == 0)
                   return mid+1;
                //如果mid左边的值还是大于等于v，则直接让right = mid-1;
                if(a[mid-1] >= v)
                    right = mid-1;
                else 
                    return mid+1;
            }
            else
                left = mid+1;
        }
        return n+1;
    }
}