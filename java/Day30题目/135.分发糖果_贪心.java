/*
	算法思想：
		自己只考虑了从左往右边满足发糖果的要求，没有满足从右到左也要满足要求！！我只考虑了一边
		
		规则定义：设A在B的左边
			左规则：当ratingB > ratingA ，B要比A的糖果多
			右规则：当ratingA > ratingB，A要比B的糖果多

		相邻的学生中，评分高的学生必须获得更多的糖果 等价于 所有学生满足左规则且满足右规则。
		
题解：https://leetcode-cn.com/problems/candy/solution/candy-cong-zuo-zhi-you-cong-you-zhi-zuo-qu-zui-da-/
*/

class Solution {
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left,1);
        Arrays.fill(right,1);
        for(int i=1;i<ratings.length;i++)
            if(ratings[i] > ratings[i-1])
                left[i] = left[i-1]+1;
        //获取最后一名学生的糖果数
        int count = left[ratings.length-1];
        for(int i = ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1])
                right[i] = right[i+1]+1;
            count += Math.max(left[i],right[i]);
        }
        return count;
    }
}