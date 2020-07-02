/*
	算法思想：
		建立最小堆
*/
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        //将矩阵转化成一个单个数组
        int[] a = new int[row * col];
        int pos =0 ;
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                a[pos++] = matrix[i][j];
            }
        int heapsize = row*col;
        //建小根堆
        buildMinHeap(a,heapsize);
        for(int i=heapsize-1;i>= row*col-k+1;i--){
            //将根节点与最后的叶子结点替换
            swap(a,0,i);
            heapsize--;
            minHeapify(a,0,heapsize);
        }
        return a[0];
    }

    public void buildMinHeap(int[] a,int heapsize){
        for(int i=heapsize/2-1;i>=0;i--)
            minHeapify(a,i,heapsize);
    }

    public void minHeapify(int[] a,int i,int heapsize){
        int l=i*2+1,r=i*2+2,smallest=i;
        if(l<heapsize && a[l]<a[smallest])
            smallest=l;
        if(r<heapsize && a[r]<a[smallest])
            smallest=r;
        if(smallest != i){
            swap(a,i,smallest);
            minHeapify(a,smallest,heapsize);
        }
    }

    public void swap(int[] a,int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
    





