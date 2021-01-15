/*
	算法思想：
		计算前缀和，然后从前缀和中随机生成一个数，从pool中找到对应的索引
		pool.get(mid)，获取的是前缀和，如果前缀和小于等于temp，一定不是我们要的，因为我要的是第一个大于随机数的最小值！
		
	评论区的解释：
		给定数组是【3,1,2】——>
      前缀和数组【0,3,4,6】——>
      在【0,6）范围生成一个随机数r ——>
          如果r=0、1、2则返回index0
          如果r=3则返回index1
          如果r=4、5则返回index2
	
	题解思想：https://leetcode-cn.com/problems/random-pick-with-weight/solution/an-quan-zhong-sui-ji-xuan-ze-by-leetcode/  +  
	https://leetcode-cn.com/problems/random-pick-with-weight/solution/qian-zhui-he-zhu-shi-by-minato-5-sitm/
*/


class Solution {
    //left是pool中大于temp的前缀和的最小下标，取left是因为随机数从0开始取！比如[1, 3]的前缀和数组是[1, 4]，
	//取的随机数是0,1,2,3 前缀和数组中1对应0，4对应0,1,2,3，所以要取poll中第一个大于temp的下标值。

    //存放前缀和
    List<Integer>  pool = new ArrayList();
    int total = 0;
    Random rand = new Random();

    public Solution(int[] w) {
        for(int weight:w){
            total += weight;
            pool.add(total);
        }
    }
    
    public int pickIndex() {
        int temp = rand.nextInt(total);//左闭右开，不包括total
        //pool的长度也就是数组的长度大小
        int left = 0,right = pool.size()-1;

        while(left < right){
            int mid = (left + right) >>> 1;
            //因为要找的是序列中大于target的最小值，所以就算当psum.get(mid) 等于target,这也不是我要的值，我要的值肯定在右边，所以lo = mid + 1.
            if(pool.get(mid) <= temp)
                left = mid+1;
            else
                right = mid;
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */