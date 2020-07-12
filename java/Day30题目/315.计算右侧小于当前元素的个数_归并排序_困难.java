/*
	算法思想：
		归并排序的思想，与求逆序数对的个数类似

https://blog.csdn.net/qq_36442947/article/details/81612870
https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/solution/gui-bing-pai-xu-suo-yin-shu-zu-python-dai-ma-java-/

		
*/
class Solution {
    int[] count;
    int[] index;// 不做真正的元素改变，基于下标进行排序
    int[] temps; // 用于临时存储下标

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList(nums.length);

        index = new int[nums.length];
        temps = new int[nums.length];
        count = new int[nums.length];

        //初始化索引数组
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
            count[i] = 0;
        }

        //归并排序
        mergeSort(nums,0,nums.length-1);

        for(int i=0;i<count.length;i++)
            res.add(count[i]);

        return res;
    }

    public void mergeSort(int[] a,int start,int end){
        if(start < end){//当子序列中只有一个元素时结束递归
            int mid = (start + end) >>> 1;
            mergeSort(a,start,mid);//对左侧子序列进行递归排序
            mergeSort(a,mid+1,end);//对右侧子序列进行递归排序
            merge(a,start,mid,end);//合并
        }
    }

    public void merge(int[] a,int left,int mid,int right){
        for (int i = left;i <= right;i++) {
            temps[i] = index[i];
        }

        int ls=left , rs = mid+1, k=left; //ls,rs是检测指针，K是存放指针
        while(ls <= mid && rs<=right){
            if(a[index[ls]] <= a[index[rs]])
                temps[k++] = index[rs++];
            else{
                temps[k++] = index[ls];
                count[index[ls]] += right - rs + 1;
                ls++;
            }
        }

        // 如果上序不满足，说明至少一边已经完全取完了，接下来只要依次把剩余的取完就好了
        // 如果左边还剩余，说明右边已经没有了。
        // 不管那一边还有剩余，都已经是这一边值最小的了，不需要加计数
        while(ls <= mid){
            temps[k++] = index[ls++];
        }
        // 如果右边还有剩余，说明左边已经没有了，
        while (rs <= right) {
            temps[k++] = index[rs++];
        }
        // 把temps 在赋值给indexs,完成排序
        for (int i = left;i <= right;i++) {
            index[i] = temps[i];
        }
    }


}





