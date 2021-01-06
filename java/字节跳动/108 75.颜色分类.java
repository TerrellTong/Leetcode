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