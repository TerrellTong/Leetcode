/*
	算法思想：
		前缀和+二分查找
	思路：从i开始进行枚举，之前的和为前缀和，然后从某一处开始+（i）*(n-i)
	
*/
class Solution {
    public int findBestValue(int[] arr, int target) {
        //先对数组进行排序
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n+1];
        //计算前缀和
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }
        int r = arr[n-1];
        int ans = 0,diff = target;
        //进行枚举
        for(int i=1;i<= r;++i){
            //Arrays.binarySearch()方法，用于从arr数组（升序），找到i的位置
            //当该值不在数组里面，返回-index-1
            //搜索值不是数组元素，且大于数组内元素，索引值为-（length+1），length是刚开始大于数组索引的值
            //{1.3.4.5.8.9},如果找6，则返回-5（-（4+1））
            int index = Arrays.binarySearch(arr,i);
            if(index < 0)
                index = -index-1;
            int cur = prefix[index] + (n-index)*i;
            if(Math.abs(cur - target) < diff){
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }
}



