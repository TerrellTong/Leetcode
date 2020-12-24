/*
	算法思想：
		二分查找！！
*/

class Solution {
    public int mySqrt(int x) {
        if( x==1 || x==0)
            return x;
        int left = 0;
        int right = x;
        while(left <= right){
            int mid = (left + right) >>> 1;
            if((long)mid * mid > x)
                right = mid -1;
            else if((long) mid * mid < x)
                left = mid + 1;
            else
                return mid;
        }
        return right;
    }
}