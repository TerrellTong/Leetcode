/*
	算法思想：
		前缀和，此次采用同余定理来进行时间复杂度的降低，
		同余定理：若（sum[j] - sum[i]）%K = 0，则必有sum[j]%K = sum[i] % K 
		因此我们只需要将前缀和直接取余即可，取余得到的数就可以与ans相加，即ans就是想要的结果
		
*/
 
class Solution {
    public int subarraysDivByK(int[] nums, int K) {
        int len = nums.length,sum = 0,ans = 0;
        int[] map = new int[K];
        map[0] = 1;
        for(int i=1;i<=len;i++){
            sum = sum+nums[i-1];
            //由于数组中有可能出现负数，我们需要将其加K从而使其%K之后的值为正数。
            int key = (sum%K + K) % K;
			//先用map[key]的值，然后再相加。如果先加再用，有可能会导致只出现一次的情况
			//如果此时map[key]的值已经大于1，说明之前存在一个前缀和满足%K 的值，因此可以用ans 进行相加
            ans += map[key];
            map[key]++;
        }
        return ans;
    }
}

//o(n^2)，超时 与560类似
public int subarraysDivByK(int[] nums, int K) {
        int res = 0;
        int len = nums.length;
        int[] preSum = new int[len+1];
        preSum[0] = 0;
        for(int i=0;i<len;i++)
            preSum[i+1] = preSum[i]+nums[i];
        //从左开始遍历
        for(int left = 0;left<len;left++)
            for(int right = left;right<len;right++){
                if((preSum[right+1] - preSum[left])% K == 0)
                    res++;
            }
        
        return res;
    }








