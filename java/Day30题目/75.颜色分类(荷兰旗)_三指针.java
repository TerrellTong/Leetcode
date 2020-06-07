/*
	算法思想：
		三指针
	
*/
 
class Solution {
    //荷兰旗问题
    public void sortColors(int[] nums) {
        //p0记录0的最右边界，p2追踪2的最左边界
        //cur记录当前元素的位置
        int p0=0,p2=nums.length-1,cur=0;
        int tmp;
        while(cur <= p2){
            //当前元素为0，与p0互换位置
            if(nums[cur] == 0){
                tmp = nums[p0];
                nums[p0] = nums[cur];
                nums[cur] = tmp;
                //p0指针右移
                p0++;
                cur++;
            }else if(nums[cur] == 2){
                tmp = nums[p2];
                nums[p2] = nums[cur];
                nums[cur] = tmp;
                //p2指针左移,此时不能cur++，因为如果此时交换后是0呢，此元素要继续交换
                p2--;
                
            }
            else
                cur++;
        }
    }
}








