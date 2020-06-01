/*
	算法思想：
		未看答案

	
	
*/
 
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> res = new ArrayList();
        int max_candy = candies[0];
        //找到最大糖果
        for(int i=0;i<candies.length;i++)
            max_candy = Math.max(max_candy,candies[i]);
        //让最大糖果进行比较
        for(int i=0;i<candies.length;i++){
            int dif = max_candy - candies[i];
            if(candies[i] == max_candy)
                res.add(true);
            
            else if(dif <= extraCandies)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}









