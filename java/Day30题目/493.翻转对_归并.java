/*
	算法思想：
		按照逆序对的思想，我知道是逆序对，但是不知道如何添加代码进行修改！
		在进行比较的时候，不要忘记同时要对数组进行归并！！！不要忘了！！
		我是按照自己的感觉进行i++,j++的!没有深刻理解归并！！
		
		利用：归并排序不断出现一对有序的左右序列，每次都是两段升序序列，规模从小（单个元素）到大
		每次，右递增序列的数，都在左递增序列找目标数，找到了，就统计一下
		下次，右序列的这些数，经过排序，会在一个新的右递增序列里，然后又在当前的左递增序列里面找目标数，找到了，统计一下。
		对于每一个数，会考察掉它左侧的所有可能。
		
		i是左侧的数，j是右侧的数
		如果恰好满足：nums[i] > 2*nums[j]，则有：
			左序列中nums[i]右侧的数，必然能和nums[j]组成翻转对，且 个数 好统计。

作者：xiao_ben_zhu
链接：https://leetcode-cn.com/problems/reverse-pairs/solution/shou-hua-tu-jie-yi-bu-yi-bu-jie-xi-gui-bing-pai-xu/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

*/

class Solution {
    int res = 0;
    public int reversePairs(int[] nums) {
        int[] tmp = new int[nums.length];
        mergesort(nums,0,nums.length-1,tmp);
        return res;   
    }

    public void  mergesort(int[] nums,int start,int end,int[] tmp){
        if(start < end){
            int mid = (start+end) >>> 1;
            mergesort(nums,start,mid,tmp);
            mergesort(nums,mid+1,end,tmp);
            merge(nums,start,mid,end,tmp);
        }
    }

    public void merge(int[] nums,int start,int mid,int end,int[] tmp){
        int j = start,k = mid+1;
        while(j <= mid && k <= end){
            if(nums[j] > 2 * (long)nums[k]){
				//由于后面都是比j大的，因此一定会满足翻转对的条件
                res += mid - j+1;
                k++; //考察下一个k
            }else
                j++;
        }

        //开始排序
        int index = 0;
        j = start; 
        k = mid+1;
        while(j <= mid && k <= end){
            if(nums[j] < nums[k])
                tmp[index++] = nums[j++];
            else
                tmp[index++] = nums[k++];
        }

        //如果左边有剩余，还是要添加
        while(j <= mid)
            tmp[index++] = nums[j++];
        
        while(k <= end)
            tmp[index++] = nums[k++];

        //将排序好的元素放到nums中
        for(int t=0;t<index;t++)
            nums[start+t] = tmp[t];
    }
}