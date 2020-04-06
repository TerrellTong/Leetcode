/*
	算法思想：
		双指针
	定理一：在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
	
	如果left_max<right_max成立，那么它就知道自己能存多少水了。
	无论右边将来会不会出现更大的right_max，都不影响这个结果。 
	
	所以当left_max<right_max时，我们就希望去处理left下标，反之，我们希望去处理right下标。
				
*/

public class Solution {
    public int trap(int[] height) {
        int ans = 0;
        //左指针
        int left = 0;
        //右指针
        int right = height.length - 1 ;
        //左右两边各自的max值
        int left_max = 0;
        int right_max = 0;
        while(left <= right){
			//如果左边的max小于右边的max，则去处理左边left
             if(left_max < right_max){
				 //如果left_max与当前的左边的height,进行做差，如果大于0说明可以盛水，小于0说明不能盛水
                ans += Math.max(0,left_max-height[left]);
				//更新left_max
                left_max = Math.max(left_max,height[left]);
                left += 1;
             }
            else{
                ans += Math.max(0,right_max-height[right]);
				//更新right_max
                right_max = Math.max(right_max,height[right]);
                right -= 1;
            }
        }
        return ans;
    }
}










