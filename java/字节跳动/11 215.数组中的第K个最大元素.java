/*
	算法思想：
		堆排序，大根堆
		新增：用快排的思想解决！（面试考察这个！！）	
		
题解：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/ 参考代码4
*/

//快排思想
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;

        //进行转换
        //目标的索引
        //例如：1,3,5,7,9，我要找第3大的元素，下标索引是nums.len-k
		
		//如果是找第k小个元素，则不需要进行索引转换！！
        int target = nums.length-k;

        while(true){
            int index = partition(nums,left,right);
            if(index == target){
                return nums[index];
            }else if(index < target)
                left = index+1;
            else
                right = index-1;
        }
    }

    public int partition(int[] nums,int left,int right){
            int pivot = nums[left];
            int i = left;
            int j = right;
            while(i < j){
                while(i < j && nums[j] >= pivot)
                    j--;
                while(i < j && nums[i] <= pivot)
                    i++;

                //交换
                if(i < j){
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            //将枢纽值(最左边的值)与i元素互换
            int t = nums[i];
            nums[i] = nums[left];
            nums[left] = t;
            return i;
            
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        for(int num:nums){
            queue.offer(num);
        }
        for(int i=1;i<k;i++)
            queue.poll();
        return queue.poll();
    }
}

