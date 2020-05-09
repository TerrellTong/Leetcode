/*
	算法思想：
		二分查找，不能用int，因为int会出现问题，要用long
*/
 
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        long start = 1;
        long end = x/2;
        long mid = 0;
        while(start <= end){
            mid = start+(end-start)/2;
            if(mid * mid <= x && (mid+1)*(mid+1)>x)
                return (int)mid;
            if(mid*mid > x)
                end = mid - 1;
            if(mid*mid < x)
                start = mid + 1;
        }
        return (int)start;
    }
}












