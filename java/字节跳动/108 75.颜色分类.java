/*
	算法思想：
		单指针思想，之前用的双指针用不习惯！！
		思想：ptr第一次遍历，用于存储下一个存0的位置，当一次遍历完成后，0已经放到了第一部分
		然后ptr指向的是1放置的位置，如果遇到1就与ptr位置的值进行交换即可！！
		最终我们得到了想要的结果！！
		
题解思路：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/  方法一

*/

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int ptr = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
        for(int i=ptr;i<n;i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = temp;
                ++ptr;
            }
        }
    }
}

//左神思想，分成三个区域，与此同时，对cur进行判断，如果满足条件，则放到对应区域的后一个位置/前一个位置！
class Solution {
    public void sortColors(int[] nums) {
        //根据左神基础班2的感悟
        int left = 0;
        int right = nums.length-1;
        //此时的less表示0区域的终止位置
        //此时的more表示2区域的起始位置
        int less = left-1;
        int more = right+1;
        //表示起始的位置
        int cur = 0;
        //只要cur不大于more，就一直循环
        while(cur<more){
            if(nums[cur] == 0){
                //cur与less区域的下一个交换
                swap(nums,++less,cur++);
            }else if(nums[cur] == 2){
                //cur交换到more区域的上一个区域
                //此时cur不能++，因为cur交换到了待定区域，有可能交换的是0/1，不确定！
                swap(nums,--more,cur);
            }else
                cur++;
        }
    }

    public void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}