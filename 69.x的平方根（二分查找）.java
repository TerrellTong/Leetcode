/*
	思想：
		二分查找
		由于提交过程中，int会出现问题，因此用long作为存储的数据变量
*/

class Solution {
    public int mySqrt(int x) {
        if(x <= 1)
            return x;
        //一个数的平方根不会超过它的一半,因此以X的一半作为high
        long high = x/2;
        long low = 1;
		//二分查找的核心模板！
        while(low < high){
            long middle = (high+low)/2;
            if(middle*middle <= x && (middle+1)*(middle+1) > x)
                return (int)middle;
            else if(middle*middle < x)
                low = middle + 1 ;
            else 
                high = middle - 1 ;
        }
        return (int)low;
    }
}







