/*
	算法思想：
		维护一个大顶堆
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        //构建一个大顶堆
        buildMaxHeap(nums,heapSize);
        //经历过nums.length-k+1次结点调整后，根节点的值为自己想要的
        for(int i=nums.length-1;i>=nums.length-k+1;--i){
            //进行堆交换(把最后一个叶子结点与根节点互换)
            swap(nums,0,i);
            --heapSize;
            //维护一个大顶堆
            maxHeapify(nums,0,heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a,int heapSize){
        //只需要处理heapSize/2个结点，因为还有一半的结点是在叶子结点
        //从heapSize/2个非叶子结点，进行结点维护
        for(int i=heapSize/2 - 1;i>=0;--i)
            maxHeapify(a,i,heapSize);
    }

    public void maxHeapify(int[] a,int i,int heapSize){
        //l：左孩子；r：右孩子
        int l=i*2 +1 ,r = i*2+2,largest = i;
        //从当前结点，及其左右子节点，找到最大的那个位置
        if(l<heapSize && a[l] > a[largest])
            largest = l;
        if(r<heapSize && a[r] > a[largest])
            largest = r;
        //如果largest不等于i,则需要对i为起点进行最大堆维护
        if(largest != i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
    





